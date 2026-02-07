package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Setting;
import cn.nopj.sflarum.domian.repository.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SettingService {
    private final SettingRepository repository;
    public Setting findById(String id) {
        return repository.findById(id);
    }
    public List<Setting> listAll() {
        return repository.findAll();
    }
    public boolean create(Setting entity) {
        return repository.create(entity);
    }
    public boolean update(Setting entity) {
        return repository.update(entity);
    }
    public boolean delete(String id) {
        return repository.delete(id);
    }
}