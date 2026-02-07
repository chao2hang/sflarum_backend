package cn.nopj.sflarum.infra.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    private String secretKey;
    private Long accessTokenExpiration;
    private Long refreshTokenExpiration;
    private String tokenPrefix;
}
