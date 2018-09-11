package Nicholas.Baltodano.Console;

import Nicholas.Baltodano.Game;
import Nicholas.Baltodano.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess{

    //Logger
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // Fields
    private final Game game;
    private final MessageGenerator messageGenerator;

    // Constructor
    public ConsoleNumberGuess(@Autowired Game game, @Autowired MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // Events
    @EventListener (ContextRefreshedEvent.class)
    public void start() {
     log.info("start: Container Ready for use.");

     Scanner scanner = new Scanner(System.in);

     while(true)
     {
         System.out.println(messageGenerator.getMainMessage());
         System.out.println(messageGenerator.getResultMessage());

         int guess = scanner.nextInt();
         scanner.nextLine();
         game.setGuess(guess);
         game.check();

         if(game.isGameWon() || game.isGameLost()){
             System.out.println(messageGenerator.getResultMessage());
             System.out.println("Would you like to play again?");

             String playAgainString = scanner.nextLine().trim();
             if(!playAgainString.equalsIgnoreCase("y")){
                 break;
             }

             game.reset();
         }
     }
    }
}































