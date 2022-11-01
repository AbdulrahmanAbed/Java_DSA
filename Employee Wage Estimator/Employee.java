package hw4;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * @author Abdulrahman
 *
 */

// Create abstract paycheck method for the manager & worker classes to add onto
// Maybe use an interface?
// use abstract methods in manager employee for difference in calculation
// use normal methods if they're doing the same thing in both classes

public class Employee {

	static String id = "";
	static int salary = 0;
	static int status = 0;

	public Employee(String id, int salary, int status) {
		this.id = id;
		this.salary = salary;
		this.status = status;
	}

	public int getPaycheck() {
		return 0;
	}
	
	

}
