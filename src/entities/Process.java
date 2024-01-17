package entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import utilities.Calculator;

public class Process {
	
	// Method to initiate the process
	public static void inputInfo() {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		// Get information
		List<Person> list = new ArrayList<>();
		System.out.println("           Calculate BMI software");
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
				System.out.print("Enter height (m): ");
				Double height = input.nextDouble();
				System.out.print("Enter weight (Kg): ");
				Double weight = input.nextDouble();
				input.nextLine();
				System.out.println();
				
				list.add(new Person(name, height, weight, Calculator.calculateBmi(height, weight), Calculator.status()));
			}
			input.close();
		}
		catch (InputMismatchException e) {
    		System.out.println("Format invalid! Insert only numbers.");
    		System.out.println("Try again, please.\n");
    		return;
    	}
    	catch (Exception e) {
    		System.out.println("Something went wrong!");
    		e.printStackTrace();
    		return;
    	}
	
		// Show information
		System.out.println("      BMI(s) registered of each person:   ");
		System.out.println("------------------------------------------");
		for (Person p : list) {
			System.out.println(p);
		}
	}
}
