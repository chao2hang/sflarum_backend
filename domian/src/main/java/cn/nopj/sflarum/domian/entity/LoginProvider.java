package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_login_providers
 * Description: login providers
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginProvider {
    private Long id;
    private Long userId;
    private String provider;
    private String identifier;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;
}
