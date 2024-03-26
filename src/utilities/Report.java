package utilities;

import model.entities.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Report {

    private static String path = "E:\\Programming\\Java\\Projects\\IdeaProjects\\Texts\\report.txt";

    // Error. Trying to fix.

//    public static void createReport(List<Person> list){
//        try{
//            Scanner sc = new Scanner(System.in);
//            System.out.print("You want to create a BMI's report data? [y/n] ");
//
//            String choice = sc.next();
//            choice = choice.toLowerCase();
//            choice = choice.trim();
//
//            if (choice.equals("y")){
//                createArchive(list);
//            }
//            else if(choice.equals("n")){
//                System.out.println("Ending...");
//            }
//            else{
//                System.out.println("Enter only with 'Y' or 'N'!");
//            }
//        }
//        catch(InputMismatchException e){
//            System.out.println("Enter with the letter required!");
//        }
//        catch (Exception e){
//            System.out.println();
//            System.out.println("Unexpected error!" +"\n" + "StackTrace:");
//            System.out.println("--------------------------------------");
//            e.printStackTrace();
//        }
//
//    }

    public static void createArchive(List<Person> list){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for (Person p : list){
                bw.write(p.toString());
            }
            System.out.println("Report created success!");
        }
        catch(IOException e){
            System.out.println("######Error######");
            e.printStackTrace();
        }
    }

}
