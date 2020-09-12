package com.ccnu.paper_service.service.ServiceImpl;

import com.ccnu.paper_service.mapper.TwoDefendantMapper;
import com.ccnu.paper_service.model.entity.DefendantTwo;
import com.ccnu.paper_service.service.DefendentTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 22:00 2020/7/14
 */
@Service
public class DefendantTwoServiceImpl implements DefendentTwoService {
  @Autowired
  private TwoDefendantMapper twoDefendantMapper;
    @Override
    public Integer saveDefendant(DefendantTwo defendantTwo) {
        return twoDefendantMapper.saveTwoDefendant(defendantTwo);
    }

    @Override
    public List<DefendantTwo> listDefendantByLawyerId(Integer lawyerId) {
        return twoDefendantMapper.listDefendantTwoByLawyerId(lawyerId);
    }
}
