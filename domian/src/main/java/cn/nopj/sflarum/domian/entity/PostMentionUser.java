package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_post_mentions_user
 * Description: post mentions user
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostMentionUser {
    private Long postId;
    private Long mentionsUserId;
    private LocalDateTime createdAt;
}
