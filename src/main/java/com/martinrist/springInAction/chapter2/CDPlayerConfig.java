package com.martinrist.springInAction.chapter2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring JavaConfig class to configure CD Player with automatic component
 * scanning.
 */

@Configuration
@ComponentScan
public class CDPlayerConfig {
}
