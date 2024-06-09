package by.peachack.hotel.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Hotel API",
                description = "Documentation of Hotel API",
                version = "1.0",
                termsOfService = "https://swagger.io/terms/",
                contact = @Contact(
                        name = "Dmitry Bulyha",
                        url = "https://github.com/PeaChack",
                        email = "dev.peachack@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://springdoc.org")
        )
)
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi api() {
        String[] paths = {"/hotels/**", "/search/**"}; // Укажите пути к вашим контроллерам
        return GroupedOpenApi.builder()
                .group("Hotels")
                .pathsToMatch(paths)
                .build();
    }

}
