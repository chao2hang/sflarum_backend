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
public class UserPo {
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private Boolean isEmailConfirmed;
    private String password;
    private String avatarUrl;
    private byte[] preferences;
    private LocalDateTime joinedAt;
    private LocalDateTime lastSeenAt;
    private LocalDateTime markedAllAsReadAt;
    private LocalDateTime readNotificationsAt;
    private Long discussionCount;
    private Long commentCount;
    private LocalDateTime readFlagsAt;
    private LocalDateTime suspendedUntil;
    private String suspendReason;
    private String suspendMessage;
    private Double money;
    private Long bestAnswerCount;
    private Integer votes;
    private String rank;
    private LocalDateTime lastVoteTime;
    private String bio;
    private String cover;
}
