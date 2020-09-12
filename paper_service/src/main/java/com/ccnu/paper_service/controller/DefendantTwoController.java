package com.ccnu.paper_service.controller;

import com.ccnu.paper_service.model.entity.DefendantOne;
import com.ccnu.paper_service.model.entity.DefendantTwo;
import com.ccnu.paper_service.service.DefendentTwoService;
import com.ccnu.paper_service.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 22:02 2020/7/14
 */
@RestController
@RequestMapping("/api/v1/pri/defendant_two")
public class DefendantTwoController {
    @Autowired
    private DefendentTwoService defendentTwoService;
    @RequestMapping("saveTwoDefendant")
    public JsonData saveTwoDefendant(@RequestBody DefendantTwo defendantTwo)
    {
        return JsonData.buildSuccess(defendentTwoService.saveDefendant(defendantTwo));


    }

    @RequestMapping("listTwoDefendantByToken")
    public JsonData listTwoDefendant(HttpServletRequest httpServletRequest)
    {

        Integer lawyer_id  = (Integer) httpServletRequest.getAttribute("id");
        System.out.println("++++++++++++"+lawyer_id);
        return JsonData.buildSuccess(defendentTwoService.listDefendantByLawyerId(lawyer_id));

    }
}
