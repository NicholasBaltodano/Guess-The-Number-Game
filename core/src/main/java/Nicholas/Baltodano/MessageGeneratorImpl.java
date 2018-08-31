package Nicholas.Baltodano;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements  MessageGenerator {

    // Logging Constants
    private static final Logger log =  LoggerFactory.getLogger(MessageGeneratorImpl.class);


    // Fields
    @Autowired
    private Game game;
    private int guessCount = 10;


    @PostConstruct
    public void init(){
        log.info("game  = {}", game);
      }


    // Public Methods
    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + " and " + game.getBiggest() +  ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon())
        {
            return "You got it ! The number was " + game.getNumber();
        }
        else if (game.isGameLost()){
            return "You lost. The number was " + game.getNumber();
        } else if (!game.isValidNumberRange()){
            return "Number is not in valid range";
        } else if(game.getRemainingGuesses() == guessCount)
        {
            return "What is your guess?";
        } else {
            String direction = "Lower";

            if(game.getGuess() < game.getNumber()){
                direction = "Guess higher!";
            }

            return direction + "You have " + game.getRemainingGuesses() + " guesses remaining.";
        }
    }
}
