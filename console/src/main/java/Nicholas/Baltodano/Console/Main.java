package Nicholas.Baltodano.Console;

import Nicholas.Baltodano.Config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Guess the Number Game");

        // Config
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        //close context
        context.close();
    }
}
