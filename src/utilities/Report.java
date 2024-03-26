package utilities;

import application.Main;
import model.entities.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class Report {

    public static void createReport(List<Person> list) {
        while (true) {
            try {
                System.out.print("You want to create a BMI's report data? [y/n] ");
                String choice = Main.sc.next();
                choice = choice.toLowerCase();
                choice = choice.trim();

                if (choice.equals("y")) {
                    createArchive(list);
                    break;
                }
                else if (choice.equals("n")) {
                    System.out.println("Ending...");
                    break;
                }
                else {
                    System.out.println("Enter only with 'Y' or 'N'!");
                    System.out.println();
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Enter with the letter required!");
            }
            catch (Exception e) {
                System.out.println();
                System.out.println("Unexpected error!" + "\n" + "StackTrace:");
                System.out.println("--------------------------------------");
                e.printStackTrace();
            }

        }
    }

    private static void createArchive(List<Person> list) {
        System.out.print("Enter the folder you want to save: ");
        String path = Main.sc.next();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Registered BMI(s):");
            bw.write("------------------");
            bw.newLine();
            for (Person p : list) {
                bw.write(p.toString());
                bw.write("------------------");
                bw.newLine();
            }
            System.out.println("Report created with success!");
            System.out.println("Folder: " + path);
        } catch (IOException e) {
            System.out.println("######Error######");
            e.printStackTrace();
        }
    }

}
