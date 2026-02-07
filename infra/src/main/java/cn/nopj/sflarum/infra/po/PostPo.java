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
public class PostPo {
    private Long id;
    private Long discussionId;
    private Long number;
    private LocalDateTime createdAt;
    private Long userId;
    private String type;
    private String content;
    private LocalDateTime editedAt;
    private Long editedUserId;
    private LocalDateTime hiddenAt;
    private Long hiddenUserId;
    private String ipAddress;
    private Boolean isPrivate;
    private Boolean isApproved;
}
