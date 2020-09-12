package com.ccnu.paper_service.mapper;

import com.ccnu.paper_service.model.entity.Lawyer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 16:36 2020/7/14
 */
public interface LawyerMapper {

    List<Lawyer> listLawyer();

    Lawyer findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    Integer saveLawyer(Lawyer lawyer);
}
