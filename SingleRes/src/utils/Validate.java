package utils;

public class Validate {
    // method to verify if a string can be parsed in an int with a try and catch
    public boolean verifyInt(String numberInString) {
        try {
            Integer.parseInt(numberInString);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    // method to validate if one of the parameter strings is equals to the required answer
    public boolean validateTwoStrings(String string1, String string2, String answer){
        return answer.equalsIgnoreCase(string1) || answer.equalsIgnoreCase(string2);
    }
}