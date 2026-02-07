package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.DiscussionUser;
import cn.nopj.sflarum.domian.entity.key.DiscussionUserKey;
import java.util.List;
public interface DiscussionUserRepository {
    DiscussionUser findById(DiscussionUserKey key);
    List<DiscussionUser> findAll();
    boolean create(DiscussionUser entity);
    boolean update(DiscussionUser entity);
    boolean delete(DiscussionUserKey key);
}