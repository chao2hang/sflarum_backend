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
public class PollVotePo {
    private Long id;
    private Long pollId;
    private Long optionId;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
