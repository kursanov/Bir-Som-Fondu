package kg.esemp.bir_som_fondu.bir_som_fonduu;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "API Documentation", version = "1.0", description = "Документация API")
)
@ComponentScan(basePackages = "kg.esemp.bir_som_fondu")

public class BirSomFonduuApplication {

    public static void main(String[] args) {
        SpringApplication.run(BirSomFonduuApplication.class, args);
        System.out.println("Ishtep  atat!");

    }

}
