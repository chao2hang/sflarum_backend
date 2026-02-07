package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.PostUser;
import cn.nopj.sflarum.domian.entity.key.PostUserKey;
import java.util.List;
public interface PostUserRepository {
    PostUser findById(PostUserKey key);
    List<PostUser> findAll();
    boolean create(PostUser entity);
    boolean update(PostUser entity);
    boolean delete(PostUserKey key);
}