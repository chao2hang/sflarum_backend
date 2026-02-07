package cn.nopj.sflarum.domian.entity.key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostMentionPostKey {
    private Long postId;
    private Long mentionsPostId;
}
