package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Table: f_flags
 * Description: flags
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flag {
    private Long id;
    private Long postId;
    private String type;
    private Long userId;
    private String reason;
    private String reasonDetail;
    private LocalDateTime createdAt;
}
