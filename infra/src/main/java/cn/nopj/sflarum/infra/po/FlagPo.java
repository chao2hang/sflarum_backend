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
public class FlagPo {
    private Long id;
    private Long postId;
    private String type;
    private Long userId;
    private String reason;
    private String reasonDetail;
    private LocalDateTime createdAt;
}
