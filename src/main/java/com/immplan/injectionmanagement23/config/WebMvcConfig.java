package com.immplan.injectionmanagement23.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new EmptyToZero.StringToIntegerConverter());
        registry.addConverter(new EmptyToZero.StringToDoubleConverter());
        registry.addConverter(new EmptyToZero.StringToFloatConverter());
    }
}

