package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Flag;
import java.util.List;
public interface FlagRepository {
    Flag findById(Long id);
    List<Flag> findAll();
    boolean create(Flag entity);
    boolean update(Flag entity);
    boolean delete(Long id);
}