package com.app.breeze.comm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 配置文件
 *
 * @author fuce
 * @ClassName: Swagger
 * @Description: Swagger配置文件
 * 访问地址:http://localhost:8080/v2/api-docs
 * ui访问地址:http://localhost:8080/swagger-ui.html
 * @date 2018年6月3日
 */
@Configuration
@EnableSwagger2 //启动swagger注解 启动服务
public class Swagger2Config extends WebMvcConfigurationSupport {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.app.breeze"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("王杰","https://justdoitwj.github.io","1327866253@163.com");
        return new ApiInfoBuilder()
                .title("Breeze API文档")
                .description("简单优雅的restfun风格，Breeze接口文档")
                .contact(contact)
                .version("1.0")
                .build();
    }

    /**
     * 解决http://localhost:8080/swagger-ui.html 访问404问题和项目静态资源无法访问的问题
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
