package cn.nopj.sflarum.domian.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Table: f_discussion_sticky_tag
 * Description: discussion sticky tag
 * Source: data.sql
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscussionStickyTag {
    private Long discussionId;
    private Long tagId;
}
