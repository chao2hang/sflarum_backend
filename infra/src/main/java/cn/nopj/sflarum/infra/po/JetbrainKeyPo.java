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
public class JetbrainKeyPo {
    private Integer id;
    private String name;
    private String keyword;
    private String softwareKey;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
