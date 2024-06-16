package by.potapenko.dbservice.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "DB service",
                description = "DB", version = "1.0.0",
                contact = @Contact(
                        name = "Potapenko Ivan",
                        email = "puivan@gmail.com"
                )
        )
)
public class OpenApiConfig {
}
