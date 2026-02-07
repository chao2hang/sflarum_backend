package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_post_mentions_group
 * Description: post mentions group
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostMentionGroup {
    private Long postId;
    private Long mentionsGroupId;
    private LocalDateTime createdAt;
}
