package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.TagUser;
import cn.nopj.sflarum.domian.entity.key.TagUserKey;
import cn.nopj.sflarum.domian.repository.TagUserRepository;
import cn.nopj.sflarum.infra.mapper.TagUserMapper;
import cn.nopj.sflarum.infra.po.TagUserPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class TagUserRepositoryImpl implements TagUserRepository {
    private final TagUserMapper mapper;
    @Override
    public TagUser findById(TagUserKey key) {
        TagUserPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        TagUser entity = new TagUser();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<TagUser> findAll() {
        List<TagUserPo> list = mapper.findAll();
        List<TagUser> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (TagUserPo po : list) {
            TagUser entity = new TagUser();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(TagUser entity) {
        TagUserPo po = new TagUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(TagUser entity) {
        TagUserPo po = new TagUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(TagUserKey key) {
        return mapper.deleteById(key) > 0;
    }
}