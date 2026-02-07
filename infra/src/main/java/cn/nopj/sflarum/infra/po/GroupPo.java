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
public class GroupPo {
    private Long id;
    private String nameSingular;
    private String namePlural;
    private String color;
    private String icon;
    private Boolean isHidden;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
