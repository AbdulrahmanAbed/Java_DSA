package hw4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

// read input file ()
// store into arraylist
// verify
// if does not verify, ask again (check verification method)
// if it does verify store 4 employees into output.xtx file

public class Main {

	public static void main(String args[]) {

		ArrayList<String> inputTxtList = new ArrayList<>();
		ArrayList<Employee> employees = new ArrayList<>();

		String employeeID = "";
		int salary = 0;
		int status = 0;

		Scanner s = new Scanner(System.in);
		System.out.println("Enter employee ID of an employee");
		String employeeidIn = s.next();
		System.out.println("Enter salary of employee");
		int salaryIn = Integer.parseInt(s.next());
		System.out.println("Is the employee a mangeer or worker (1 for worker and 2 for manager)");
		int statusIn = Integer.parseInt(s.next());

		String line;
		int employeeidCount = 0;
		int salaryCount = 1;
		int statusCount = 2;

		try {
			Scanner scan = new Scanner(new FileReader("input.txt"));
			while (scan.hasNextLine()) {
				line = scan.next();
				inputTxtList.add(line);

				employeeID = inputTxtList.get(employeeidCount);

				salary = Integer.parseInt(inputTxtList.get(salaryCount));
				status = Integer.parseInt(inputTxtList.get(statusCount));

				// if I make the employee class an abstract, it wont let me instantiate the
				// employee object
				// SO I need to make an if statement to check the status value and add the
				// appropriate object
				for (int i = 0; i < 5; i++) {
					if (employeeID.equals(employeeidIn)) {
						if (salary == salaryIn) {
							if (status == statusIn) {
								Employee emp = new Employee(employeeID, salary, status);
								employees.add(emp);
							}
						}
					}

					else
						System.out.println("The information provided is not correct");
					// ask again
				}
				employeeidCount += 3;
				salaryCount += 3;
				statusCount += 3;

				System.out.println(line);
				System.out.println(inputTxtList);
			}

		} catch (Exception e) {
			System.out.println("The file could not be found");
			e.printStackTrace();
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
			// writer.write(employee to the output file);
			writer.newLine();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
