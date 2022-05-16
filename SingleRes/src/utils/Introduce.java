package utils;
import java.util.Scanner;

public class Introduce {
    private final Scanner input = new Scanner(System.in);
    private final Validate validate = new Validate();
    private final Show show = new Show();

    // method to ask user an int value
    public int askIntValue(){
        String numberInString = input.next();
        while (!validate.verifyInt(numberInString)){
            show.showMessage("Introduce a valid number: ", "red");
            numberInString = input.next();
        }
        return Integer.parseInt(numberInString);
    }

    // method to ask user a string value
    public String askStringValue(){
        return input.nextLine();
    }

    // method to ask user to introduce one of two options required
    public String askTwoOptionString(String s1, String s2){
        String valueIntroduced = input.next();
        while (!validate.validateTwoStrings(s1, s2, valueIntroduced)){
            show.showMessage("Please enter a correct value (Yes/No): " , "red");
            valueIntroduced = input.next();
        }

        return valueIntroduced;
    }
}
