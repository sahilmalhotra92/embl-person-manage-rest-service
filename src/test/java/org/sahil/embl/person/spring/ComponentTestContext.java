package org.sahil.embl.person.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.sahil.embl.person")
@EnableAutoConfiguration
public class ComponentTestContext {

}

