package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.RankUser;
import cn.nopj.sflarum.domian.entity.key.RankUserKey;
import java.util.List;
public interface RankUserRepository {
    RankUser findById(RankUserKey key);
    List<RankUser> findAll();
    boolean create(RankUser entity);
    boolean update(RankUser entity);
    boolean delete(RankUserKey key);
}