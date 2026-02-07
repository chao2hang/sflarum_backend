package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.TagUser;
import cn.nopj.sflarum.domian.entity.key.TagUserKey;
import java.util.List;
public interface TagUserRepository {
    TagUser findById(TagUserKey key);
    List<TagUser> findAll();
    boolean create(TagUser entity);
    boolean update(TagUser entity);
    boolean delete(TagUserKey key);
}