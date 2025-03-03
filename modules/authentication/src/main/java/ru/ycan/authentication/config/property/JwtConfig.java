package ru.ycan.authentication.config.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtConfig(@JsonProperty("ttl") long ttl) {
}
