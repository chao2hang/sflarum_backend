package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_polls
 * Description: polls
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Poll {
    private Long id;
    private String question;
    private String subtitle;
    private String image;
    private String imageAlt;
    private Long postId;
    private Long userId;
    private Boolean publicPoll;
    private LocalDateTime endDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long voteCount;
    private Boolean allowMultipleVotes;
    private Long maxVotes;
    private String settings;
}
