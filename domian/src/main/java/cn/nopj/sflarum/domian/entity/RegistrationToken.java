package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_registration_tokens
 * Description: registration tokens
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationToken {
    private String token;
    private String payload;
    private LocalDateTime createdAt;
    private String provider;
    private String identifier;
    private String userAttributes;
}
