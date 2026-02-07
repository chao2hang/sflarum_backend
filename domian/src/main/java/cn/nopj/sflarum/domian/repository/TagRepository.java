package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Tag;
import java.util.List;
public interface TagRepository {
    Tag findById(Long id);
    List<Tag> findAll();
    boolean create(Tag entity);
    boolean update(Tag entity);
    boolean delete(Long id);
}