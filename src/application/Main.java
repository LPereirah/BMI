package application;

import model.entities.Person;
import model.exceptions.ProcessException;
import model.entities.Calculator;
import utilities.Report;

import java.util.*;

public class Main{

	public static Scanner sc;
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		sc = new Scanner(System.in);

		// Get information
		List<Person> list = new ArrayList<>();

		while (true) {
			try {
				System.out.println("         BMI Calculator Program");
				System.out.println("------------------------------------------");
				System.out.print("How many people will have the BMI calculate? ");
				int n = sc.nextInt();
				sc.nextLine();
				System.out.println();

				System.out.println("                   Menu                   ");
				System.out.println("------------------------------------------");

				for (int i = 0; i < n; i++) {
					System.out.printf("Below, enter the information of #%d person:%n", i + 1);
					System.out.print("Enter name: ");
					String name = sc.nextLine();
					Person.validate(name);
					System.out.print("Enter height (m): ");
					Double height = sc.nextDouble();
					System.out.print("Enter weight (Kg): ");
					Double weight = sc.nextDouble();
					sc.nextLine();
					System.out.println();

					list.add(new Person(name, height, weight, Calculator.calculateBmi(height, weight), Calculator.status()));
				}

				// Show information
				System.out.println("            BMI(s) registered:");
				System.out.println("------------------------------------------");
				for (Person p : list) {
					System.out.println(p);
				}

				// Create a report
				Report.createReport(list);
			}
			catch (InputMismatchException e) {
				System.out.println("Format invalid! Insert only numbers.");
				System.out.println("Try again, please.\n");
				sc.nextLine();
				continue;
			}
			catch (ProcessException e) {
				System.out.println("Error: " + e.getMessage());
				System.out.println();
				continue;
			}
			catch (Exception e) {
				System.out.println("Something went wrong!");
				e.printStackTrace();
				continue;
			}

			break;
		}
	}

}
