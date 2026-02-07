package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.JetbrainKey;
import cn.nopj.sflarum.domian.repository.JetbrainKeyRepository;
import cn.nopj.sflarum.infra.mapper.JetbrainKeyMapper;
import cn.nopj.sflarum.infra.po.JetbrainKeyPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class JetbrainKeyRepositoryImpl implements JetbrainKeyRepository {
    private final JetbrainKeyMapper mapper;
    @Override
    public JetbrainKey findById(Integer id) {
        JetbrainKeyPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        JetbrainKey entity = new JetbrainKey();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<JetbrainKey> findAll() {
        List<JetbrainKeyPo> list = mapper.findAll();
        List<JetbrainKey> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (JetbrainKeyPo po : list) {
            JetbrainKey entity = new JetbrainKey();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(JetbrainKey entity) {
        JetbrainKeyPo po = new JetbrainKeyPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(JetbrainKey entity) {
        JetbrainKeyPo po = new JetbrainKeyPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Integer id) {
        return mapper.deleteById(id) > 0;
    }
}