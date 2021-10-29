package app.config;

import app.model.property.SwaggerProperty;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: bai
 * @Date: 2021/10/29 10:02
 */
@AllArgsConstructor
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private final SwaggerProperty swaggerProperty;

    @Bean
    public Docket docket(){
        List<Parameter> parameterList = new ArrayList<>();

        ParameterBuilder tokenPram = new ParameterBuilder();
        tokenPram.name("token")
                .description("用于token校验")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .defaultValue("token123456")
                .build();
        parameterList.add(tokenPram.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperty.getBasePackage()))
                .build()
                .globalOperationParameters(parameterList);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(swaggerProperty.getTitle())
                .version(swaggerProperty.getVersion())
                .build();
    }
}
