package com.tvajjala.swagger.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Swagger UI project configuration to render, clean API documentation without using springfox annotations
 *
 * @author ThirupathiReddy Vajjala
 */

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {


    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfig.class);


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        LOGGER.info("Adding resource handlers to the swagger UI");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/static/swagger-ui.html");
        registry.addResourceHandler("api/**").addResourceLocations("classpath:/api-doc/");
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        LOGGER.info("Enabling Cross Origin Resource Sharing  ");
        registry.addMapping("/*");// all the end-points now can be accessible from other domains
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "swagger-ui.html");
    }

}
