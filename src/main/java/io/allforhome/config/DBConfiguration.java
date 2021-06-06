package io.allforhome.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author mkemiche
 * @created 01/05/2021
 */
@PropertySource(value = {"classpath:application.properties"})
@Configuration
public class DBConfiguration {

}
