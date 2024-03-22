package application;

import model.entities.Person;
import model.exceptions.ProcessException;
import model.entities.Calculator;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		// Get information
		List<Person> list = new ArrayList<>();

		System.out.println("         BMI Calculator Program");
		System.out.println("------------------------------------------");

		try {
			System.out.print("How many people will have the BMI calculate? ");
			int n = input.nextInt();
			System.out.println();
			input.nextLine();

			System.out.println("                   Menu                   ");
			System.out.println("------------------------------------------");

			for (int i = 0; i < n; i++) {
				System.out.printf("Below, enter the information of #%d person:%n", i + 1);
				System.out.print("Enter name: ");
				String name = input.nextLine();
				Person.validate(name);
				System.out.print("Enter height (m): ");
				Double height = input.nextDouble();
				System.out.print("Enter weight (Kg): ");
				Double weight = input.nextDouble();
				input.nextLine();
				System.out.println();

				list.add(new Person(name, height, weight, Calculator.calculateBmi(height, weight), Calculator.status()));
			}

			input.close();
			// Show information
			System.out.println("      BMI(s) registered of each person:   ");
			System.out.println("------------------------------------------");
			for (Person p : list) {
				System.out.println(p);
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Format invalid! Insert only numbers.");
			System.out.println("Try again, please.\n");
		}
		catch (ProcessException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Something went wrong!");
			e.printStackTrace();
		}
	}
}
