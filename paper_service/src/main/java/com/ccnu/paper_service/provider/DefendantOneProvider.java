package com.ccnu.paper_service.provider;

import com.ccnu.paper_service.model.entity.DefendantOne;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 10:51 2020/8/3
 */
public class DefendantOneProvider {
    public  String UpdateDefendantOne(final DefendantOne defendantOne)
    {
        return new SQL()
        {
            {
                UPDATE("defendant_one");
                if(defendantOne.getName()!=null)
                {
                    SET("name = #{name}");
                }
                if(defendantOne.getAddress()!=null)
                {
                    SET("address = #{address}");
                }
                if(defendantOne.getCardNum()!=null)
                {
                    SET("card_num = #{cardNum}");
                }
                if(defendantOne.getNature()!=null)
                {
                    SET("nature = #{nature}");
                }
                if(defendantOne.getSex()!=null)
                {
                    SET("sex = #{sex}");
                }
                if(defendantOne.getLawyerId()!=null)
                {
                    SET("lawyer_id = #{lawyerId}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }
}
