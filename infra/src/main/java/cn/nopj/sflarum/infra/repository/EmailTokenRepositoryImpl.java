package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.EmailToken;
import cn.nopj.sflarum.domian.repository.EmailTokenRepository;
import cn.nopj.sflarum.infra.mapper.EmailTokenMapper;
import cn.nopj.sflarum.infra.po.EmailTokenPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class EmailTokenRepositoryImpl implements EmailTokenRepository {
    private final EmailTokenMapper mapper;
    @Override
    public EmailToken findById(String id) {
        EmailTokenPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        EmailToken entity = new EmailToken();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<EmailToken> findAll() {
        List<EmailTokenPo> list = mapper.findAll();
        List<EmailToken> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (EmailTokenPo po : list) {
            EmailToken entity = new EmailToken();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(EmailToken entity) {
        EmailTokenPo po = new EmailTokenPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(EmailToken entity) {
        EmailTokenPo po = new EmailTokenPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(String id) {
        return mapper.deleteById(id) > 0;
    }
}