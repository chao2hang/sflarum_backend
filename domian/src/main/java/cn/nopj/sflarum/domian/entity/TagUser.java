package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_tag_user
 * Description: tag user
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagUser {
    private Long userId;
    private Long tagId;
    private LocalDateTime markedAsReadAt;
    private Boolean isHidden;
    private String subscription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
