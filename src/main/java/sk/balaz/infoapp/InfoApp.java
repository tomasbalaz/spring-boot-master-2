package sk.balaz.infoapp;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("info.app")
public record InfoApp(
        String name,
        String description,
        String version) { }
