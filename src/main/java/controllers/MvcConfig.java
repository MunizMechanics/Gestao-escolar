package controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/alunos").setViewName("alunos");
        registry.addViewController("/disciplinas").setViewName("disciplinas");
        registry.addViewController("/gestores").setViewName("gestores");
        registry.addViewController("/cursos").setViewName("cursos");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("/");
        registry.addViewController("/menu").setViewName("menu");
        
        
    }
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
