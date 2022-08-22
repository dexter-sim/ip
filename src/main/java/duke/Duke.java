package duke;

import duke.command.Command;

/**
 * The main class for the Duke program.
 *
 * @author dexter-sim
 * @version 0.1
 */
public class Duke {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    /**
     * Creates a Duke object with specified file path to load and store tasks.
     *
     * @param filePath The file path to the local file responsible for loading and saving.
     */
    public Duke(String filePath) {
        try {
            ui = new Ui();
            storage = new Storage(filePath);
            taskList = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.printErrorMessage(e.getMessage());
            taskList = new TaskList();
        }
    }

    /**
     * Runs the Duke program.
     */
    public void run() {
        ui.printGreeting();
        boolean isExit = false;
        while (!isExit) {
            try {
                String userInput = ui.read();
                Command command = Parser.parseInput(userInput);
                command.execute(storage, taskList, ui);
                isExit = command.canExit();
            } catch (DukeException e) {
                ui.printErrorMessage(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Duke("data/duke.txt").run();
    }
}
