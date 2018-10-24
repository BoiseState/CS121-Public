import java.util.ArrayList;

/**
 * Lesson 16: Activity - ToDoList
 * 
 * Interface for a ToDoList.
 * 
 * @author marissa, mvail
 * @version Fall 2018
 */
public interface ToDoListInterface
{
	/**
	 * Returns the name of this ToDoList.
	 * @return the name.
	 */
	public String getName();

	/**
	 * Adds the given task to this list.
	 * @param task The task to add.
	 */
	public void addTask(Task task);

	/**
	 * Adds a task with the given description to this list.
	 * @param description Description of the task to add.
	 */
        public void addTask(String description);

	/**
	 * Returns the next incomplete task with the highest priority.  
	 * @return the next task or null if there are no tasks in the list or if all the tasks are complete.
	 */
	public Task getWork();

	/**
	 * Returns a copy of the tasks ArrayList, not a reference to the internal
	 *    list of tasks.
	 * @return a copy of the tasks ArrayList.
	 */
	public ArrayList<Task> getTaskList();

	/**
	 * Returns a string of all the tasks in the list, one per line. 
	 * <pre>
	 * -------------
	 * ToDoList name
	 * -------------
	 * task 1
	 * task 2
	 * etc...
	 * </pre>
	 * @return a String representing the ToDoList.
	 */
	public String toString();

}
