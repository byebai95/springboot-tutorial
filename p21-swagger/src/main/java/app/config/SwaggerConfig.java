package app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info =
@Info(title = "Swagger3.0构建API文档", version = "1.0", description = "Swagger3.0构建API文档 v1.0"))
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi restApi() {
        return GroupedOpenApi.builder()
                .group("rest-api")
                .pathsToMatch("/rest/**")
                .build();
    }

    @Bean
    public GroupedOpenApi helloApi() {
        return GroupedOpenApi.builder()
                .group("hello")
                .pathsToMatch("/hello/**")
                .build();
    }

    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder()
                .group("all")
                .pathsToMatch("/**")
                .build();
    }
}
