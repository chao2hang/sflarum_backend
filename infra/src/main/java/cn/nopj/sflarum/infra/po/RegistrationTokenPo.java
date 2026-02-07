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
public class RegistrationTokenPo {
    private String token;
    private String payload;
    private LocalDateTime createdAt;
    private String provider;
    private String identifier;
    private String userAttributes;
}
