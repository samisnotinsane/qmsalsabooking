package info.sameen.qmsalsabooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Configuration for Swagger API document generator.
 * @author sameenislam
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("info.sameen.qmsalsabooking"))
                .paths(regex("/api.*"))
                .build();
    }

    private ApiInfo meta() {
        ApiInfo apiInfo = new ApiInfo(
                "QM Salsa Society API",
                "Book classes and register attendees",
                "1.0",
                "Terms of Service",
                "Sameen Islam",
                "GNU GPLv3",
                "https://www.gnu.org/licenses/licenses.html"
        );
        return apiInfo;
    }
}
