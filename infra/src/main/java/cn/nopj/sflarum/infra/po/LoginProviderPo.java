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
public class LoginProviderPo {
    private Long id;
    private Long userId;
    private String provider;
    private String identifier;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;
}
