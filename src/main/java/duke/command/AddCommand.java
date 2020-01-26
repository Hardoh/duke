package duke.command;

import duke.task.Task;
import duke.task.TaskList;
import duke.util.Storage;

public class AddCommand extends Command {

    private String toAdd;
    private Task.TaskType taskType;

    /**
     * AddCommand constructor.
     * @param toAdd string name of new task.
     * @oaram taskType of the new task.
     */
    public AddCommand(String toAdd, Task.TaskType taskType) {
        this.toAdd = toAdd;
        this.taskType = taskType;
    }

    /**
     * Executes Add behaviour of adding a new task.
     * @param taskList to access collection of tasks.
     * @param storage to access save-load functionality.
     */
    public void execute(TaskList taskList, Storage storage) {
        Task newTask = taskList.AddTask(toAdd, taskType);
        if (newTask != null)
            storage.SaveTaskToFile(newTask);
    }

    /**
     * Inform if command is an exit command.
     * @return boolean indicating if command is an exit command.
     */
    public boolean isExit() {
        return false;
    }
}