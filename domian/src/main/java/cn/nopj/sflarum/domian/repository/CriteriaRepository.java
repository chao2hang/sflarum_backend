package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Criteria;
import java.util.List;
public interface CriteriaRepository {
    Criteria findById(Long id);
    List<Criteria> findAll();
    boolean create(Criteria entity);
    boolean update(Criteria entity);
    boolean delete(Long id);
}