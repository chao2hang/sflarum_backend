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
public class DraftPo {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String relationships;
    private LocalDateTime updatedAt;
    private LocalDateTime scheduledFor;
    private String scheduledValidationError;
    private String ipAddress;
    private String extra;
}
