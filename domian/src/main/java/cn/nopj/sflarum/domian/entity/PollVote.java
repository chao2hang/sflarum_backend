package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_poll_votes
 * Description: poll votes
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PollVote {
    private Long id;
    private Long pollId;
    private Long optionId;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
