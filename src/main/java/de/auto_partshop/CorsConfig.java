package de.auto_partshop;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Разрешаем запросы со всех доменов
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Разрешенные методы
                .allowedHeaders("*"); // Разрешаем все заголовки
    }
}