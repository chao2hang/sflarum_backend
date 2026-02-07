package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.PostMentionGroup;
import cn.nopj.sflarum.domian.entity.key.PostMentionGroupKey;
import java.util.List;
public interface PostMentionGroupRepository {
    PostMentionGroup findById(PostMentionGroupKey key);
    List<PostMentionGroup> findAll();
    boolean create(PostMentionGroup entity);
    boolean update(PostMentionGroup entity);
    boolean delete(PostMentionGroupKey key);
}