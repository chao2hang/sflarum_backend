package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Draft;
import java.util.List;
public interface DraftRepository {
    Draft findById(Long id);
    List<Draft> findAll();
    boolean create(Draft entity);
    boolean update(Draft entity);
    boolean delete(Long id);
}