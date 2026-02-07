package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_discussion_user
 * Description: discussion user
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscussionUser {
    private Long userId;
    private Long discussionId;
    private LocalDateTime lastReadAt;
    private Long lastReadPostNumber;
    private String subscription;
}
