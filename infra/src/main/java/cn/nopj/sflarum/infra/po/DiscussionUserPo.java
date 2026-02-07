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
public class DiscussionUserPo {
    private Long userId;
    private Long discussionId;
    private LocalDateTime lastReadAt;
    private Long lastReadPostNumber;
    private String subscription;
}
