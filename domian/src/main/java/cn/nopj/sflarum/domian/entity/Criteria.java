package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Table: f_criteria
 * Description: criteria
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Criteria {
    private Long id;
    private Long lastEditedById;
    private String name;
    private String icon;
    private String description;
    private String metrics;
    private String requirements;
    private String actions;
}
