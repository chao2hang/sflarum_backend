package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_post_mentions_tag
 * Description: post mentions tag
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostMentionTag {
    private Long postId;
    private Long mentionsTagId;
    private LocalDateTime createdAt;
}
