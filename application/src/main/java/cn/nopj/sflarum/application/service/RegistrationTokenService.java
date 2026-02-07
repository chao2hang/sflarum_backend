package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.RegistrationToken;
import cn.nopj.sflarum.domian.repository.RegistrationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RegistrationTokenService {
    private final RegistrationTokenRepository repository;
    public RegistrationToken findById(String id) {
        return repository.findById(id);
    }
    public List<RegistrationToken> listAll() {
        return repository.findAll();
    }
    public boolean create(RegistrationToken entity) {
        return repository.create(entity);
    }
    public boolean update(RegistrationToken entity) {
        return repository.update(entity);
    }
    public boolean delete(String id) {
        return repository.delete(id);
    }
}