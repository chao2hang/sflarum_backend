package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.Tag;
import cn.nopj.sflarum.domian.repository.TagRepository;
import cn.nopj.sflarum.infra.mapper.TagMapper;
import cn.nopj.sflarum.infra.po.TagPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class TagRepositoryImpl implements TagRepository {
    private final TagMapper mapper;
    @Override
    public Tag findById(Long id) {
        TagPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        Tag entity = new Tag();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<Tag> findAll() {
        List<TagPo> list = mapper.findAll();
        List<Tag> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (TagPo po : list) {
            Tag entity = new Tag();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(Tag entity) {
        TagPo po = new TagPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(Tag entity) {
        TagPo po = new TagPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}