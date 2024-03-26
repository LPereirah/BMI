package model.entities;

import model.exceptions.ProcessException;

public class Person {

    private String name, status;
    private Double height,  weight, bmi;

    public Person(String name, Double height, Double weight, Double bmi, String status) throws ProcessException{
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.status = status;
    }

    public static void validate(String name)throws ProcessException {
        name = name.replaceAll("\\s", ""); // Gather the words, without blank spaces, to validate.
        if (isNumber(name)){
            throw new ProcessException("Enter a name, not a number!");
        }
    }

    private static boolean isNumber(String name){
        name = name.replaceAll("\\s", "");
        try {
            Double.parseDouble(name);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public String toString(){
        return String.format("Name: %s,%n", name)
             + String.format("Height (m): %.2f,%n", height)
             + String.format("Weight (Kg): %.2f,%n", weight)
             + String.format("BMI: %.2f,%n", bmi)
             + String.format("Status: %s.%n", status);
    }

}
