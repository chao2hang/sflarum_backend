package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_access_tokens
 * Description: access tokens
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessToken {
    private Long id;
    private String token;
    private Long userId;
    private LocalDateTime lastActivityAt;
    private LocalDateTime createdAt;
    private String type;
    private String title;
    private String lastIpAddress;
    private String lastUserAgent;
}
