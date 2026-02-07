package cn.nopj.sflarum.infra.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PollPo {
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
