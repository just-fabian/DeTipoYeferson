package game;

public class Player {
    private String name;
    private int attempts = 0;

    // method to set the player name received as parameter
    public void setName(String name) {
        this.name = name;
    }

    // method to increase in one the number of attempts of the player
    public void increaseOneAttempt(){
        attempts = attempts + 1;
    }

    // method to return the player's name
    public String getName() {
        return name;
    }

    // method to return the number of attempts of the player
    public int getAttempts() {
        return attempts;
    }

    // Optional: This method was thought in case we add the function to play another game
    public void resetAttemps(){attempts = 0;}
}
