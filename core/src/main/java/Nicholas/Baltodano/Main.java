package Nicholas.Baltodano;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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


        log.info("get Main message = {}", messageGenerator.getMainMessage());
        log.info("get Result message = {}",messageGenerator.getResultMessage());

        //close context
        context.close();


    }
}
