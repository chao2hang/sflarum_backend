package cn.nopj.sflarum.domian.entity.key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupUserKey {
    private Long userId;
    private Long groupId;
}
