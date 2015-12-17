package com.martinrist.springInAction.chapter2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring JavaConfig class to configure CD Player.  Note the lack of
 * the @ComponentScan annotation, which means we need to do configuration
 * manually.
 */

@Configuration
public class CDPlayerJavaConfig {

    // This method defines the sgtPeppers Bean
    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }


    @Bean
    public CDPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }

    @Bean
    public CDPlayer anotherCDPlayer() {
        return new CDPlayer(sgtPeppers());
    }

}
