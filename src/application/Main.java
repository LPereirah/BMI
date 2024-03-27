package application;

import model.entities.Person;
import model.exceptions.ProcessException;
import model.entities.Calculator;
import utilities.Report;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main{

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		List<Person> list = new ArrayList<>();

		String answer = null;

		// Get information
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
				System.out.print("You want to create a BMI report? [y/n] ");
				answer = sc.next();
				System.out.println(Report.createArchive(list, answer));
			}
			catch (FileNotFoundException e){
				System.out.println(e.getMessage());
				System.out.println();
				continue;
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
			catch (InputMismatchException e) {
				System.out.println("Format invalid! Insert only numbers.");
				System.out.println("Try again, please.\n");
				sc.nextLine();
				continue;
			}
			catch (ProcessException e) {
				System.out.println(e.getMessage());
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
		sc.close();
		System.out.println();
		System.out.println("Ending program...");
	}

}
