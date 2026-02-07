package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_jetbrains_keys
 * Description: jetbrains keys
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JetbrainKey {
    private Integer id;
    private String name;
    private String keyword;
    private String softwareKey;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
