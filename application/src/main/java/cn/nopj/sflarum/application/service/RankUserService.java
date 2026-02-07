package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.RankUser;
import cn.nopj.sflarum.domian.entity.key.RankUserKey;
import cn.nopj.sflarum.domian.repository.RankUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RankUserService {
    private final RankUserRepository repository;
    public RankUser findById(RankUserKey key) {
        return repository.findById(key);
    }
    public List<RankUser> listAll() {
        return repository.findAll();
    }
    public boolean create(RankUser entity) {
        return repository.create(entity);
    }
    public boolean update(RankUser entity) {
        return repository.update(entity);
    }
    public boolean delete(RankUserKey key) {
        return repository.delete(key);
    }
}