package hw4;

/**
 * @author Abdulrahman
 *
 */

public class ManagerEmployee extends Employee {

	public ManagerEmployee(String id, int salary, int status) {
		super(id, salary, status);
	}
	
	@Override
	public int getPaycheck() {
        return (int)((this.getSalary() / 12) * 1.2);
    }

	private int getSalary() {
		return salary;
	}


}
