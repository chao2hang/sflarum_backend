package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.DiscussionUser;
import cn.nopj.sflarum.domian.entity.key.DiscussionUserKey;
import cn.nopj.sflarum.domian.repository.DiscussionUserRepository;
import cn.nopj.sflarum.infra.mapper.DiscussionUserMapper;
import cn.nopj.sflarum.infra.po.DiscussionUserPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class DiscussionUserRepositoryImpl implements DiscussionUserRepository {
    private final DiscussionUserMapper mapper;
    @Override
    public DiscussionUser findById(DiscussionUserKey key) {
        DiscussionUserPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        DiscussionUser entity = new DiscussionUser();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<DiscussionUser> findAll() {
        List<DiscussionUserPo> list = mapper.findAll();
        List<DiscussionUser> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (DiscussionUserPo po : list) {
            DiscussionUser entity = new DiscussionUser();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(DiscussionUser entity) {
        DiscussionUserPo po = new DiscussionUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(DiscussionUser entity) {
        DiscussionUserPo po = new DiscussionUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(DiscussionUserKey key) {
        return mapper.deleteById(key) > 0;
    }
}