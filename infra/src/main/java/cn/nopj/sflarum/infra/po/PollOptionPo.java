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
public class PollOptionPo {
    private Long id;
    private String answer;
    private Long pollId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long voteCount;
    private String imageUrl;
}
