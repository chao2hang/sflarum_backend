package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Rank;
import java.util.List;
public interface RankRepository {
    Rank findById(Long id);
    List<Rank> findAll();
    boolean create(Rank entity);
    boolean update(Rank entity);
    boolean delete(Long id);
}