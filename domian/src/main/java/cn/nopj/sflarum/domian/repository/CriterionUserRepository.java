package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.CriterionUser;
import cn.nopj.sflarum.domian.entity.key.CriterionUserKey;
import java.util.List;
public interface CriterionUserRepository {
    CriterionUser findById(CriterionUserKey key);
    List<CriterionUser> findAll();
    boolean create(CriterionUser entity);
    boolean update(CriterionUser entity);
    boolean delete(CriterionUserKey key);
}