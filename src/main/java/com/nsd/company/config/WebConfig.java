package com.nsd.company.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Nilesh Dhawale
 * @since 09-April-2024
 * @version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")  // Allow requests from this origin
            .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow these methods
            .allowedHeaders("*");  // Allow all headers
    }
}
