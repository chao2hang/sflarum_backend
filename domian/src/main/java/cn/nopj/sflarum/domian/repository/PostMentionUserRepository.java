package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.PostMentionUser;
import cn.nopj.sflarum.domian.entity.key.PostMentionUserKey;
import java.util.List;
public interface PostMentionUserRepository {
    PostMentionUser findById(PostMentionUserKey key);
    List<PostMentionUser> findAll();
    boolean create(PostMentionUser entity);
    boolean update(PostMentionUser entity);
    boolean delete(PostMentionUserKey key);
}