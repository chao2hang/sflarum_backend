package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_api_keys
 * Description: api keys
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiKey {
    private String key;
    private Long id;
    private String allowedIps;
    private String scopes;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime lastActivityAt;
}
