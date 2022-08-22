package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Command to mark a task as incomplete.
 *
 * @author dexter-sim
 * @version 0.1
 */
public class UnmarkCommand extends Command {
    private int index;

    /**
     * Creates an unmark command with specified index.
     *
     * @param index The 1-indexed position of the task in the list.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the command to mark a task as incomplete.
     *
     * @param storage Storage handling the file IO.
     * @param taskList A list of tasks.
     * @param ui A ui to handle printing output.
     */
    @Override
    public void execute(Storage storage, TaskList taskList, Ui ui) {
        try {
            ui.printUnmarkTask(taskList.unmarkTask(index - 1));
            storage.save(taskList.getTasks());
        } catch (DukeException e) {
            ui.printErrorMessage(e.getMessage());
        }
    }
}
