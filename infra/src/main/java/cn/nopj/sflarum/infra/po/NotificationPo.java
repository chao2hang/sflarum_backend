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
public class NotificationPo {
    private Long id;
    private Long userId;
    private Long fromUserId;
    private String type;
    private Long subjectId;
    private byte[] data;
    private LocalDateTime createdAt;
    private Boolean isDeleted;
    private LocalDateTime readAt;
}
