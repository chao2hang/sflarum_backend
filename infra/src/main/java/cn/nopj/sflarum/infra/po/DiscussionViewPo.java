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
public class DiscussionViewPo {
    private Long id;
    private Long userId;
    private Long discussionId;
    private String ip;
    private LocalDateTime visitedAt;
}
