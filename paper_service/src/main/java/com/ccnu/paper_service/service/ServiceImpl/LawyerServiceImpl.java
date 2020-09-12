package com.ccnu.paper_service.service.ServiceImpl;

import com.ccnu.paper_service.mapper.LawyerMapper;
import com.ccnu.paper_service.model.entity.Lawyer;
import com.ccnu.paper_service.service.LawyerService;
import com.ccnu.paper_service.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 16:40 2020/7/14
 */
@Service
public class LawyerServiceImpl implements LawyerService {
    @Autowired
    private LawyerMapper lawyerMapper;
    @Override
    public List<Lawyer> listLawyer() {
        return lawyerMapper.listLawyer();
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        Lawyer lawyer = lawyerMapper.findByPhoneAndPwd(phone,pwd);
        if(lawyer==null)
            return null;
        else
            return JwtUtils.JsonWebToken(lawyer);


    }

    @Override
    public Integer saveLawyer(Lawyer lawyer) {
        return lawyerMapper.saveLawyer(lawyer);
    }
}
