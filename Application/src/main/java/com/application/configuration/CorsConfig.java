package com.application.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Adjust this based on your API endpoints
                .allowedOrigins("http://localhost:4200") // Adjust the origin to match your Angular app
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Adjust allowed methods as needed
                .allowCredentials(true)
                .maxAge(3600);
    }
}
