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
public class BadgeCategoryPo {
    private Long id;
    private String name;
    private Integer order;
    private String description;
    private Boolean isEnabled;
    private LocalDateTime createdAt;
    private Boolean isTable;
}
