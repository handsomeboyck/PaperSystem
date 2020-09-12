package com.ccnu.paper_service.service;


import com.ccnu.paper_service.model.entity.DefendantTwo;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 21:59 2020/7/14
 */
public interface DefendentTwoService {
    Integer saveDefendant(DefendantTwo defendantTwo);

    List<DefendantTwo> listDefendantByLawyerId(Integer lawyerId);
}
