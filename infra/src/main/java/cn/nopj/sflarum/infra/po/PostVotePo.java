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
public class PostVotePo {
    private Long id;
    private Long postId;
    private Long userId;
    private Integer value;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
