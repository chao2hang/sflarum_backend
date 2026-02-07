package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_notifications
 * Description: notifications
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
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
