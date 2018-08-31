package Nicholas.Baltodano.Console;

import Nicholas.Baltodano.AppConfig;
import Nicholas.Baltodano.MessageGenerator;
import Nicholas.Baltodano.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        log.info("Guess the Number Game");

        // Config
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // Call Method next() to get a random number
        int number = numberGenerator.next();

        //get Message Generator bean from context (container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        log.info(messageGenerator.getMainMessage());
        log.info((messageGenerator.getResultMessage()));

        //close context
        context.close();


    }
}
