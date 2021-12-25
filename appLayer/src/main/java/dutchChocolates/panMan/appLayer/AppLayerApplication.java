package dutchChocolates.panMan.appLayer;

import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppLayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppLayerApplication.class, args);
    }

}
