package duke.task;

/**
 * Abstract class for a task.
 *
 * @author dexter-sim
 * @version 0.1
 */
public abstract class Task {
    private String description;
    private boolean isDone;

    /**
     * Creates a task with specified description.
     *
     * @param description The description of the task to be created.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Creates a task with specified description and completeness.
     *
     * @param description The description of the task to be created.
     * @param isDone If the task is completed.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Marks the task as complete.
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Marks the task as incomplete.
     */
    public void unmark() {
        this.isDone = false;
    }

    private String getStatusIcon() {
        return this.isDone ? "X" : " ";
    }

    /**
     * Returns the task in a string format to be saved in a local file.
     *
     * @return A string corresponding to the task.
     */
    public String stringify() {
        return String.format("%d | %s", this.isDone ? 1 : 0, this.description);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", this.getStatusIcon(), this.description);
    }
}
