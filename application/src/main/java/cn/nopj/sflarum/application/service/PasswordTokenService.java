package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.PasswordToken;
import cn.nopj.sflarum.domian.repository.PasswordTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PasswordTokenService {
    private final PasswordTokenRepository repository;
    public PasswordToken findById(String id) {
        return repository.findById(id);
    }
    public List<PasswordToken> listAll() {
        return repository.findAll();
    }
    public boolean create(PasswordToken entity) {
        return repository.create(entity);
    }
    public boolean update(PasswordToken entity) {
        return repository.update(entity);
    }
    public boolean delete(String id) {
        return repository.delete(id);
    }
}