package com.ccnu.paper_service.service.ServiceImpl;

import com.ccnu.paper_service.mapper.OneDefendantMapper;
import com.ccnu.paper_service.model.entity.DefendantOne;
import com.ccnu.paper_service.service.DefendantOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 17:10 2020/7/14
 */
@Service
public class DefendantOneServiceImpl implements DefendantOneService {
    @Autowired
    private OneDefendantMapper oneDefendantMapper;
    @Override
    public Integer saveDefendant(DefendantOne defendantOne) {
        return oneDefendantMapper.saveOneDefendant(defendantOne);
    }

    @Override
    public Integer update(DefendantOne defendantOne) {
        return oneDefendantMapper.updateDefendantOne(defendantOne);
    }

    @Override
    public List<DefendantOne> findByName(String name) {
        return oneDefendantMapper.findByName(name);
    }

    @Override
    public Integer deleteById(Integer id) {
        return oneDefendantMapper.deleteById(id);
    }

    @Override
    public List<DefendantOne> listDefendantByLawyerId(Integer lawyerId) {
        return oneDefendantMapper.listDefendantByLawyerId(lawyerId);
    }

    @Override
    public int Count() {
        return oneDefendantMapper.count();
    }

    @Override
    public List<DefendantOne> selectByPage(int start, int end) {
        return oneDefendantMapper.selectByPage(start,end);
    }
}
