package com.example.demo;

import com.example.demo.services.FileStorageProperties;
import com.example.demo.services.FiltroFarmacia;
import com.example.demo.services.FiltroCliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})

/*
 
  @author Alcídia Cristina
 */

public class DemoApplication {
    @Bean
    public FilterRegistrationBean filtroJwtAdministrador(){
        FilterRegistrationBean fr = new FilterRegistrationBean();
        fr.setFilter(new FiltroFarmacia());
        fr.addUrlPatterns("/admin/*");
        return fr;
    }
    
    @Bean
    public FilterRegistrationBean filtroJwtCliente(){
        FilterRegistrationBean fr = new FilterRegistrationBean();
        fr.setFilter(new FiltroCliente());
        fr.addUrlPatterns("/auth/*");
        return fr;
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
