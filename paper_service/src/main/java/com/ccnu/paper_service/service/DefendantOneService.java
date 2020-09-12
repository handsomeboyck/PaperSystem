package com.ccnu.paper_service.service;

import com.ccnu.paper_service.model.entity.DefendantOne;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 17:09 2020/7/14
 */
public interface DefendantOneService {
    Integer saveDefendant(DefendantOne defendantOne);

    List<DefendantOne> listDefendantByLawyerId(Integer lawyerId);

    Integer update(DefendantOne defendantOne);

    Integer deleteById(Integer id);

    List<DefendantOne> findByName(String name);

    int Count();

    List<DefendantOne> selectByPage(int start,int end);
}
