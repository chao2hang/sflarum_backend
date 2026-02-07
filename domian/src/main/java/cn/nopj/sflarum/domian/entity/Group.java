package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_groups
 * Description: groups
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private Long id;
    private String nameSingular;
    private String namePlural;
    private String color;
    private String icon;
    private Boolean isHidden;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
