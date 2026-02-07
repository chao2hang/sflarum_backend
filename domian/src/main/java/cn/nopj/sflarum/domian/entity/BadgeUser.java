package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_badge_user
 * Description: badge user
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BadgeUser {
    private Long id;
    private Long userId;
    private Long badgeId;
    private String description;
    private Boolean isPrimary;
    private LocalDateTime assignedAt;
    private Boolean inUserCard;
}
