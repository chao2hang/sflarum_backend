package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_badge_category
 * Description: badge category
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BadgeCategory {
    private Long id;
    private String name;
    private Integer order;
    private String description;
    private Boolean isEnabled;
    private LocalDateTime createdAt;
    private Boolean isTable;
}
