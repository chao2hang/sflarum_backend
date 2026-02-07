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
public class DiscussionPo {
    private Long id;
    private String title;
    private Integer commentCount;
    private Long participantCount;
    private Long postNumberIndex;
    private LocalDateTime createdAt;
    private Long userId;
    private Long firstPostId;
    private LocalDateTime lastPostedAt;
    private Long lastPostedUserId;
    private Long lastPostId;
    private Long lastPostNumber;
    private LocalDateTime hiddenAt;
    private Long hiddenUserId;
    private String slug;
    private Boolean isPrivate;
    private Boolean isApproved;
    private Boolean isSticky;
    private Boolean isLocked;
    private Integer viewCount;
    private Long bestAnswerPostId;
    private Long bestAnswerUserId;
    private Boolean bestAnswerNotified;
    private LocalDateTime bestAnswerSetAt;
    private Integer votes;
    private Double hotness;
    private Boolean isStickiest;
    private Boolean isTagSticky;
}
