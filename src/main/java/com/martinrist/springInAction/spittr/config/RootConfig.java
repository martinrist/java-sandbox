package com.martinrist.springInAction.spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

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

    @Bean
    public JndiObjectFactoryBean dataSource() {
        JndiObjectFactoryBean factoryBean = new JndiObjectFactoryBean();
        factoryBean.setJndiName("jdbc/SpittrDS");
        factoryBean.setResourceRef(true);
        factoryBean.setProxyInterface(javax.sql.DataSource.class);
        return factoryBean;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
