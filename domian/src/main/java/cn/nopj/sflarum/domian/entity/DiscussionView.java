package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_discussion_views
 * Description: discussion views
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscussionView {
    private Long id;
    private Long userId;
    private Long discussionId;
    private String ip;
    private LocalDateTime visitedAt;
}
