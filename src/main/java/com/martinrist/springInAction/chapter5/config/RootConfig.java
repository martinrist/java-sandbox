package com.martinrist.springInAction.chapter5.config;

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
@ComponentScan(basePackages = {"com.martinrist.springInAction.chapter5"},
               excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
}
