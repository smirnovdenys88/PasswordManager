package com.project.password.manager.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("Access-Control-Allow-Origin")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH","OPTIONS")
                        .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept")
                        .maxAge(3600);
            }
        };
    }
}
