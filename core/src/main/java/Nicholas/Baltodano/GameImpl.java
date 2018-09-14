package Nicholas.Baltodano;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Slf4j
@Getter
public class GameImpl implements Game {

    // Fields
    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

    private final int guessCount;
    private int       number;
    private int       smallest;
    private int       biggest;
    private int       remainingGuesses;
    private boolean   validNumberRange = true;

    @Setter
    private int       guess;

    // Constructor
    public GameImpl(@Autowired NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount      = guessCount;
    }

    // Initilization
    @PostConstruct
    @Override
    public void reset() {
        smallest         =  numberGenerator.getMinNumber();
        guess            = 0;
        remainingGuesses = guessCount;
        biggest          = numberGenerator.getMaxNumber();
        number           = numberGenerator.next();

    }

    // Public Methods
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
        remainingGuesses--;
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

