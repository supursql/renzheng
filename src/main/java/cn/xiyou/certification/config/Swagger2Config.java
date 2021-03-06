package cn.xiyou.certification.config;

import com.google.common.base.Predicate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix ="swagger")
public class Swagger2Config {
    private boolean disable;

    @Bean
    public Docket createRestApi() {
        Predicate selector = PathSelectors.any();
        if (disable) {
            selector = PathSelectors.none();
        }

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.xiyou"))
                .paths(selector)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("工具接口")
                .version("1.0.0.")
                .build();
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

}
