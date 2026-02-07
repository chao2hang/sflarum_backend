package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_post_mentions_post
 * Description: post mentions post
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostMentionPost {
    private Long postId;
    private Long mentionsPostId;
    private LocalDateTime createdAt;
}
