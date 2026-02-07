package cn.nopj.sflarum.infra.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiKeyPo {
    private String key;
    private Long id;
    private String allowedIps;
    private String scopes;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime lastActivityAt;
}
