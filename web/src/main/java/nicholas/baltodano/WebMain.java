package nicholas.baltodano;

import nicholas.baltodano.config.WebConfigs;
import nicholas.baltodano.controller.GameController;
import nicholas.baltodano.service.GameServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import({WebConfigs.class, GameServiceImpl.class, GameController.class})
public class WebMain {
    public static void main(String[] args) {
        SpringApplication.run(WebMain.class, args);
    }
}
