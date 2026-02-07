package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.Setting;
import cn.nopj.sflarum.domian.repository.SettingRepository;
import cn.nopj.sflarum.infra.mapper.SettingMapper;
import cn.nopj.sflarum.infra.po.SettingPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class SettingRepositoryImpl implements SettingRepository {
    private final SettingMapper mapper;
    @Override
    public Setting findById(String id) {
        SettingPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        Setting entity = new Setting();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<Setting> findAll() {
        List<SettingPo> list = mapper.findAll();
        List<Setting> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (SettingPo po : list) {
            Setting entity = new Setting();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(Setting entity) {
        SettingPo po = new SettingPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(Setting entity) {
        SettingPo po = new SettingPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(String id) {
        return mapper.deleteById(id) > 0;
    }
}