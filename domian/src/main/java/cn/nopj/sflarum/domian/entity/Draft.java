package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_drafts
 * Description: drafts
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Draft {
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
