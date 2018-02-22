package com.codecool;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.codecool.crypto",
        "com.codecool.helper",
        "com.codecool.service"})
public class Config {
}
