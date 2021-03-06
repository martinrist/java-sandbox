package com.martinrist.springInAction.spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class JaxWsConfig {

    @Bean
    public SimpleJaxWsServiceExporter jaxWsExporter() {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost:8081/services/");
        return exporter;
    }


}
