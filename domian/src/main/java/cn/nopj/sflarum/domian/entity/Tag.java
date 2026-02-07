package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_tags
 * Description: tags
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    private Long id;
    private String name;
    private String slug;
    private String description;
    private String color;
    private String imageUrl;
    private String backgroundPath;
    private String backgroundMode;
    private Integer position;
    private Long parentId;
    private String defaultSort;
    private Boolean isRestricted;
    private Boolean isHidden;
    private Long discussionCount;
    private LocalDateTime lastPostedAt;
    private Long lastPostedDiscussionId;
    private Long lastPostedUserId;
    private String icon;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long postCount;
    private Boolean isQna;
    private Boolean qnaReminders;
}
