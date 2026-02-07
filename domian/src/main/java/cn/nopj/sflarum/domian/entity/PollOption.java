package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_poll_options
 * Description: poll options
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PollOption {
    private Long id;
    private String answer;
    private Long pollId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long voteCount;
    private String imageUrl;
}
