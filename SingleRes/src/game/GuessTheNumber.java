package game;

import utils.Introduce;
import utils.Show;

public class GuessTheNumber {
    private int randomNumber, numberIntroduced;
    private String answerReadyPlayer;
    private final Introduce introduce = new Introduce();
    private final Show show = new Show();
    private final Player player = new Player();

    // method to show the welcome message to the player
    private void welcome(){
        show.showMessage("\t\t-----> Welcome to the game 'GUESS THE NUMBER' <-----",
                "cyan");
    }

    // method to set the player name introduced
    private void askPlayerName(){
        show.showMessage("Please enter your name: ");
        player.setName(introduce.askStringValue());
    }

    // method to set the attribute answerReadyPlayer asking the player if he/she is ready or wants to play
    private void askIfPlayerIsReady() {
        show.showMessage(player.getName() + ", are you ready? (Yes/No): ");
        answerReadyPlayer = introduce.askTwoOptionString("Yes", "No");
    }

    // method which execute an action depending on the answer of the player in method askIfPlayerIsReady()
    private void executeActionByCondition() {
        if (answerReadyPlayer.equalsIgnoreCase("Yes")) runGame();
        else showGameOff();
    }

    // method to show the message in case the player is not ready or not wants to play
    private void showGameOff(){
        show.showMessage(player.getName() + " come back when you are ready :) !!");
    }

    // method to set the attribute randomNumber a generated random number between 1 and 100
    public void generateRandomNumber(){
        randomNumber = (int) (Math.random() * 100 + 1);
    }

    // method to show the main game question to the player
    private void showGameQuestion(){
        show.showMessage(player.getName() + ", I'm thinking in a number from 1 to" +
                " 100 guess what is it?: ");
    }

    // method in which the player plays a try by entering the number he thinks is correct
    private void playAttempt(){
        numberIntroduced = introduce.askIntValue();
        player.increaseOneAttempt();
    }

    // method that will check if number introduced by the player is correct to play another attempt
    private void checkNumber(){
        while (numberIntroduced != randomNumber) {
            showWrongNumberMessage();
            playAttempt();
        }
    }

    // method that will tell the player if the number introduced is greater or smaller than the correct
    private void showWrongNumberMessage(){
        String differenceMessage = numberIntroduced < randomNumber ? "greater" : "smaller";
        show.showMessage("Wrong, please enter a new number " + differenceMessage +
                " than " + numberIntroduced + ": ", "blue");
    }

    // method that will show a message when the player wins
    private void showVictoryMessage(){
        show.showMessage("Correct! The number is " + randomNumber + ", congratulations " +
                player.getName() + "! you won a chocolate. (Your attempts: "
                + player.getAttempts() + ")", "cyan");
    }

    // method to call the game methods used to play in case the player wants to play
    private void runGame() {
        generateRandomNumber();
        showGameQuestion();
        playAttempt();
        checkNumber();
        showVictoryMessage();
    }

    // main method of the game which calls methods to initialize the program before playing
    public void start(){
        welcome();
        askPlayerName();
        askIfPlayerIsReady();
        executeActionByCondition();
    }
}