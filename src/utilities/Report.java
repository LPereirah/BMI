package utilities;

import model.entities.Person;
import model.exceptions.ProcessException;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Report {

    public static String createArchive(List<Person> list, String answer) throws ProcessException, IOException{
        Scanner input = new Scanner(System.in);
        validateAnswer(answer);


        if (validateAnswer(answer)) {
            System.out.print("Enter address folder to save the report: ");
            String path = input.next();
            System.out.println();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                bw.write("Registered BMI(s):");
                bw.newLine();
                bw.write("------------------");
                bw.newLine();

                for (Person p : list) {
                    bw.write(p.toString());
                    bw.newLine();
                }

                return "Report created with success!" + "\n" + String.format("Folder: %s", path);
            }
            catch (FileNotFoundException e){
                throw new FileNotFoundException("File not found. Select a file, not a folder!");
            }
            catch(IOException e) {
                e.printStackTrace();
                throw new IOException("Something unexpected went wrong.");
            }

        }
        else {
            input.close();
            return "";
        }
    }

    private static boolean validateAnswer(String answer) throws ProcessException{
        answer = answer.toLowerCase();
        answer = answer.trim();

        if (answer.equals("y")){
            return true;
        }
        else if (answer.equals("n")) {
            return false;
        }
        else {
            throw new ProcessException("Enter only with 'Y' or 'N'!");
        }
    }

}
