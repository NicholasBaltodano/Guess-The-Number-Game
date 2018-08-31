package Nicholas.Baltodano;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class GameImpl implements Game {

    // Logger Constants
    private static Logger log = LoggerFactory.getLogger(GameImpl.class);

    // Fields
    @Autowired
    private NumberGenerator numberGenerator;
    private int guessCount = 10;
    private int number;
    private int smallest;
    private int guess;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    // constructors
   // public GameImpl(NumberGenerator numberGenerator) {
   //     this.numberGenerator = numberGenerator;
   // }

    // Initilization
    @PostConstruct
    @Override
    public void reset() {
        smallest         = 0;
        guess            = 0;
        remainingGuesses = guessCount;
        biggest          = numberGenerator.getMaxNumber();
        number           = numberGenerator.next();

        //log.info("The Game has been reset");
       // log.info("The number is {}", number);

    }
    // Public Methods




    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }


    @Override
    public void check() {
        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }

            if (guess < number) {
                smallest = guess + 1;
            }
        }
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
                return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // Private Methods
    private void checkValidNumberRange()
    {
        validNumberRange = (guess >=smallest) && (guess <= biggest);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("in Game PreDestroy()");
    }
}

