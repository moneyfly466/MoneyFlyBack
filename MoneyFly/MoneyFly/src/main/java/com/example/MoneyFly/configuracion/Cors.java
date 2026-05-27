package com.example.MoneyFly.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración de CORS (Cross-Origin Resource Sharing).
 * Permite que la aplicación frontend acceda a los endpoints del backend desde diferentes orígenes.
 */
@Configuration
public class Cors {

    /**
     * Configura las políticas de CORS para la aplicación.
     * Permite GET, POST, PUT, DELETE en todos los endpoints con cualquier origen.
     *
     * @return Configurador de CORS
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*");
            }
        };
    }
}