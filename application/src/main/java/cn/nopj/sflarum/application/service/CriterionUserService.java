package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.CriterionUser;
import cn.nopj.sflarum.domian.entity.key.CriterionUserKey;
import cn.nopj.sflarum.domian.repository.CriterionUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CriterionUserService {
    private final CriterionUserRepository repository;
    public CriterionUser findById(CriterionUserKey key) {
        return repository.findById(key);
    }
    public List<CriterionUser> listAll() {
        return repository.findAll();
    }
    public boolean create(CriterionUser entity) {
        return repository.create(entity);
    }
    public boolean update(CriterionUser entity) {
        return repository.update(entity);
    }
    public boolean delete(CriterionUserKey key) {
        return repository.delete(key);
    }
}