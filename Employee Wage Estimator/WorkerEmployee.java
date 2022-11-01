package hw4;

/**
 * @author Abdulrahman
 *
 */

public class WorkerEmployee extends Employee {

	public WorkerEmployee(String id, int salary, int status) {
		super(id, salary, status);
	}

	@Override
    public int getPaycheck() {
        return (this.getSalary() / 12) - 100;
    }

	private int getSalary() {
		return salary;
	}
	
}
