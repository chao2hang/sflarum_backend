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
public class AccessTokenPo {
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
