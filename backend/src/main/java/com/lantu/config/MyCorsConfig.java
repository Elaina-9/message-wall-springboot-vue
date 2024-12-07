package com.lantu.config;

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class MyCorsConfig {

    @Bean
    public CorsFilter consFilter(){
        CorsConfiguration configuration= new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8888");  //允许跨域的域名，如果要携带cookie，不能写*，*代表所有域名都可以跨域访问

        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        configuration.addAllowedMethod("OPTIONS");
        configuration.addAllowedMethod("HEAD");
        configuration.addAllowedMethod("GET");
        configuration.addAllowedMethod("PUT");
        configuration.addAllowedMethod("POST");
        configuration.addAllowedMethod("DELETE");
        configuration.addAllowedMethod("PATCH");

        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource= new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", configuration);

        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
