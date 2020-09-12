package com.ccnu.paper_service.service;

import com.ccnu.paper_service.model.entity.Lawyer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 16:40 2020/7/14
 */
public interface LawyerService {
    List<Lawyer> listLawyer();
   String findByPhoneAndPwd( String phone, String pwd);

   Integer saveLawyer(Lawyer lawyer);


}
