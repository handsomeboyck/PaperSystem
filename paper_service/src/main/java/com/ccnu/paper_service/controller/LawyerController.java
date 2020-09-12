package com.ccnu.paper_service.controller;

import com.ccnu.paper_service.model.entity.Lawyer;
import com.ccnu.paper_service.service.LawyerService;
import com.ccnu.paper_service.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 16:42 2020/7/14
 */
@RestController
@RequestMapping("/api/v1/pri/lawyer")
public class LawyerController {
    @Autowired
    private LawyerService lawyerService;
    @RequestMapping("/listLawyer")
    public JsonData findAllLawyer()
    {
        return JsonData.buildSuccess(lawyerService.listLawyer());
    }

    @RequestMapping("/login")
    public JsonData login(@RequestBody Lawyer lawyer)
    {
        String token = lawyerService.findByPhoneAndPwd(lawyer.getPhone(),lawyer.getPwd());
        if(token==null)
            return JsonData.buildError("登陆失败,账号或密码错误");
        return JsonData.buildSuccess(token);
    }

    @RequestMapping("/register")
    public JsonData register(@RequestBody Lawyer lawyer)
    {
        return JsonData.buildSuccess(lawyerService.saveLawyer(lawyer));

    }
}
