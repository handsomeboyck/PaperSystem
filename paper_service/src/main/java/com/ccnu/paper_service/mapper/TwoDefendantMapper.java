package com.ccnu.paper_service.mapper;


import com.ccnu.paper_service.model.entity.DefendantTwo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 21:46 2020/7/14
 */
public interface TwoDefendantMapper {
    Integer saveTwoDefendant(DefendantTwo defendantTwo);

    List<DefendantTwo> listDefendantTwoByLawyerId(@Param("lawyer_id") Integer lawyerId);
}
