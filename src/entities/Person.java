package entities;

public class Person {

    private String name, status;
    private Double height,  weight, bmi;

    public Person(String name, Double height, Double weight, Double bmi, String status) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public String toString(){
        return String.format("Name: %s%n", name)
             + String.format("Height (m): %.2f%n", height)
             + String.format("Weight (Kg): %.2f%n", weight)
             + String.format("BMI: %.2f%n", bmi)
             + String.format("Status: %s%n", status);
    }
}
