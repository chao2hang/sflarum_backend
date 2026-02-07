package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.RegistrationToken;
import cn.nopj.sflarum.domian.repository.RegistrationTokenRepository;
import cn.nopj.sflarum.infra.mapper.RegistrationTokenMapper;
import cn.nopj.sflarum.infra.po.RegistrationTokenPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class RegistrationTokenRepositoryImpl implements RegistrationTokenRepository {
    private final RegistrationTokenMapper mapper;
    @Override
    public RegistrationToken findById(String id) {
        RegistrationTokenPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        RegistrationToken entity = new RegistrationToken();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<RegistrationToken> findAll() {
        List<RegistrationTokenPo> list = mapper.findAll();
        List<RegistrationToken> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (RegistrationTokenPo po : list) {
            RegistrationToken entity = new RegistrationToken();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(RegistrationToken entity) {
        RegistrationTokenPo po = new RegistrationTokenPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(RegistrationToken entity) {
        RegistrationTokenPo po = new RegistrationTokenPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(String id) {
        return mapper.deleteById(id) > 0;
    }
}