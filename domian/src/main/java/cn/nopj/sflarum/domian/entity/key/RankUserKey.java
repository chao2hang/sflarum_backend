package cn.nopj.sflarum.domian.entity.key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RankUserKey {
    private Long userId;
    private Long rankId;
}
