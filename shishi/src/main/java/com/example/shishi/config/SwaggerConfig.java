package com.example.shishi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @Author: KenChen
 * @Description: swagger配置
 * @Date: Create in  2021/7/26 上午10:23
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "swagger swagger swagger",
                "                                                  风调码顺\n" +
                        "                                          上                   下\n" +
                        "                                          拜                   跪\n" +
                        "                                          图                   关\n" +
                        "                                          灵                   公\n" +
                        "                                          只                   但\n" +
                        "                                          佑                   求\n" +
                        "                                          服                   永\n" +
                        "                                          务                   不\n" +
                        "                                          可                   宕\n" +
                        "                                          用                   机\n",
                "API V1.0",
                "",
                new Contact("", "", ""),
                "", "", Collections.emptyList());
    }

}