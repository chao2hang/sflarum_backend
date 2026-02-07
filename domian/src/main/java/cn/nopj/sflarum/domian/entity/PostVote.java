package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_post_votes
 * Description: post votes
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostVote {
    private Long id;
    private Long postId;
    private Long userId;
    private Integer value;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
