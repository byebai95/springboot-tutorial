package app.model.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: bai
 * @Date: 2021/10/29 10:06
 */
@Data
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperty {

    private String title;

    private String version;

    private String basePackage;

}
