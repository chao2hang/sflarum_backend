package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_posts
 * Description: posts
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long id;
    private Long discussionId;
    private Long number;
    private LocalDateTime createdAt;
    private Long userId;
    private String type;
    private String content;
    private LocalDateTime editedAt;
    private Long editedUserId;
    private LocalDateTime hiddenAt;
    private Long hiddenUserId;
    private String ipAddress;
    private Boolean isPrivate;
    private Boolean isApproved;
}
