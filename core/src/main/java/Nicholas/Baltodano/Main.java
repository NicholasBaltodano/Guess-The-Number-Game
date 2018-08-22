package Nicholas.Baltodano;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the Number Game");

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        // Call Method next() to get a random number
        int number = numberGenerator.next();

        // log the number
        //log.info("Number = {}", number);

        //get game bean from context (container)
        Game game  = context.getBean(Game.class);

        // call reset method
        game.reset();

        //close context
        context.close();


    }
}
