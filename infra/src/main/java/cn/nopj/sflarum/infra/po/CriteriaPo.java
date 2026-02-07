package cn.nopj.sflarum.infra.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriteriaPo {
    private Long id;
    private Long lastEditedById;
    private String name;
    private String icon;
    private String description;
    private String metrics;
    private String requirements;
    private String actions;
}
