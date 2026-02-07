package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.PasswordToken;
import cn.nopj.sflarum.domian.repository.PasswordTokenRepository;
import cn.nopj.sflarum.infra.mapper.PasswordTokenMapper;
import cn.nopj.sflarum.infra.po.PasswordTokenPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class PasswordTokenRepositoryImpl implements PasswordTokenRepository {
    private final PasswordTokenMapper mapper;
    @Override
    public PasswordToken findById(String id) {
        PasswordTokenPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        PasswordToken entity = new PasswordToken();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<PasswordToken> findAll() {
        List<PasswordTokenPo> list = mapper.findAll();
        List<PasswordToken> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (PasswordTokenPo po : list) {
            PasswordToken entity = new PasswordToken();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(PasswordToken entity) {
        PasswordTokenPo po = new PasswordTokenPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(PasswordToken entity) {
        PasswordTokenPo po = new PasswordTokenPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(String id) {
        return mapper.deleteById(id) > 0;
    }
}