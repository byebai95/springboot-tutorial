package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
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

@Component
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        List<Parameter> parameterList = new ArrayList<>();

        //本地信息
        ParameterBuilder locale = new ParameterBuilder();
        locale.name("locale").description("国际化请求头。\n简体中文：zh_CN;\n美式英语：en_US;\n马来西亚语：ms_MY;\n泰国语：th_TH;\n繁体中文：zh_TW;\n越南语：vi_VN;\n新加坡华语：zh_SG")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .hidden(false)
                .required(false)
                .defaultValue("zh_CN")
                .order(Ordered.HIGHEST_PRECEDENCE)
                .required(true)
                .build();
        parameterList.add(locale.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("app")) //指定提供接口所在的基包
                .build()
                .globalOperationParameters(parameterList);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Test Title")
                .version("1.0.0")
                .description("API")
                .build();
    }




}
