package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.PostMentionPost;
import cn.nopj.sflarum.domian.entity.key.PostMentionPostKey;
import java.util.List;
public interface PostMentionPostRepository {
    PostMentionPost findById(PostMentionPostKey key);
    List<PostMentionPost> findAll();
    boolean create(PostMentionPost entity);
    boolean update(PostMentionPost entity);
    boolean delete(PostMentionPostKey key);
}