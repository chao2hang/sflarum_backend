package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.PostMentionTag;
import cn.nopj.sflarum.domian.entity.key.PostMentionTagKey;
import java.util.List;
public interface PostMentionTagRepository {
    PostMentionTag findById(PostMentionTagKey key);
    List<PostMentionTag> findAll();
    boolean create(PostMentionTag entity);
    boolean update(PostMentionTag entity);
    boolean delete(PostMentionTagKey key);
}