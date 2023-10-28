package utilities;

public class Calculator {

    public static Double calculateBmi(Double height, Double weight){
        return weight / Math.pow(height, 2);
    }

}
