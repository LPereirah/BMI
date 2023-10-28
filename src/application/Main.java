package application;

import entities.Person;
import utilities.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        inputInfo();
    }

    public static void inputInfo() {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        //            Get information
        List<Person> list = new ArrayList<>();
        System.out.println("           Calculate BMI software");
        System.out.println("------------------------------------------");

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
            System.out.print("Enter height: ");
            Double height = input.nextDouble();
            System.out.print("Enter weight: ");
            Double weight = input.nextDouble();
            input.nextLine();
            System.out.println();

            list.add(new Person(name, height, weight, Calculator.calculateBmi(height, weight), Calculator.status()));
        }

        //            Show information
        System.out.println("      BMI(s) registered of each person:   ");
        System.out.println("------------------------------------------");
        for (Person p : list) {
            System.out.println(p);
        }

    }

}
