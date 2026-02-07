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
public class BadgePo {
    private Long id;
    private String name;
    private String icon;
    private Integer order;
    private String image;
    private String description;
    private Boolean isVisible;
    private LocalDateTime createdAt;
    private Long badgeCategoryId;
    private Integer points;
    private String backgroundColor;
    private String iconColor;
    private String labelColor;
}
