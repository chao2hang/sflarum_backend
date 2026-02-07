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
public class TagUserPo {
    private Long userId;
    private Long tagId;
    private LocalDateTime markedAsReadAt;
    private Boolean isHidden;
    private String subscription;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
