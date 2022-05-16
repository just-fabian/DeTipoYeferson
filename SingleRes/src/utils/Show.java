package utils;

public class Show{
    private final Colors colors = new Colors();

    // this method is used to print a line of the String message received as parameter.
    public void showMessage(String message){
        System.out.println(message);
    }

    // Overload of the method showMessage to print the message with the color received and then reset the color
    public void showMessage(String message, String color){
        String colorToShow;
        switch (color){
            case "red":
                colorToShow = colors.RED;
                break;
            case "blue":
                colorToShow = colors.BLUE;
                break;
            case "cyan":
                colorToShow = colors.CYAN;
                break;
            default:
                colorToShow = colors.RESET;
        }
        System.out.println(colorToShow + message + colors.RESET);
    }
}