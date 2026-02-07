package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_discussion_tag
 * Description: discussion tag
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscussionTag {
    private Long discussionId;
    private Long tagId;
    private LocalDateTime createdAt;
}
