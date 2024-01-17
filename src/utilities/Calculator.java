package utilities;

public class Calculator {

    private static Double bmi;

    public static Double calculateBmi(Double height, Double weight){
        bmi = weight / Math.pow(height, 2);
        return bmi;
    }

    public static String status(){
        String status;
        if (bmi < 16){
            status = "Underweight(Severe thinness)";
        }
        else if(bmi >= 16 && bmi < 17){
            status = "Underweight (Moderate thinness)";
        }
        else if(bmi >= 17 && bmi < 18.5){
            status = "Underweight (Mild thinness)";
        }
        else if(bmi >= 18.5 && bmi < 25){
            status = "Normal range";
        }
        else if(bmi >= 25 && bmi < 30){
            status = "Overweight (Pre-obese)";
        }
        else if(bmi >= 30 && bmi < 35){
            status = "Obese (Class I)";
        }
        else if(bmi >= 35 && bmi < 40){
            status = "Obese (Class II)";
        }
        else{
            status = "Obese (Class III)";
        }
        return status;
    }
    
    
}
