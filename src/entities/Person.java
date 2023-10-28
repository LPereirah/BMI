package entities;

public class Person {

    private String name;
    private Double height,  weight, bmi;

    public Person(String name, Double height, Double weight, Double bmi) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
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
             + String.format("Height: %.2f%n", height)
             + String.format("Weight: %.2f%n", weight)
             + String.format("BMI: %.2f%n", bmi);
    }
}
