package com.martinrist.springInAction.spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Minimal root context configuration for the Spittr Web App.
 * Currently configured to do a component scan on all classes in the chapter's
 * package, excluding those annotated with @EnableWebMvc.
 */
@Configuration
@ComponentScan(basePackages = {"com.martinrist.springInAction.spittr"},
               excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {

    @Bean
    public String imageUploadDir() {
        return "/tmp/spittr/profiles";
    }

}
