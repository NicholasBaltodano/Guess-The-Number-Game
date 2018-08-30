package Nicholas.Baltodano;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.security.PublicKey;

@Configuration
@ComponentScan(basePackages = "Nicholas.Baltodano")
public class AppConfig {

    @Bean
    public NumberGenerator numberGenerator()
    {
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game(){
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }
}
