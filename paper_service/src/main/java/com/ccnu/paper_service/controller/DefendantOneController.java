package com.ccnu.paper_service.controller;

import com.ccnu.paper_service.model.entity.DefendantOne;
import com.ccnu.paper_service.service.DefendantOneService;
import com.ccnu.paper_service.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 17:13 2020/7/14
 */
@RestController
@RequestMapping("/api/v1/pri/defendant_one")
public class DefendantOneController {
    @Autowired
    private DefendantOneService defendantOneService;
    @RequestMapping("saveOneDefendant")
    public JsonData saveOneDefendant(@RequestBody DefendantOne defendantOne)
    {
        return JsonData.buildSuccess(defendantOneService.saveDefendant(defendantOne));


    }

    @RequestMapping("listOneDefendantByToken")
    public JsonData listOneDefendant(HttpServletRequest httpServletRequest)
    {

        Integer lawyer_id  = (Integer) httpServletRequest.getAttribute("id");
        System.out.println("++++++++++++"+lawyer_id);
        return JsonData.buildSuccess(defendantOneService.listDefendantByLawyerId(lawyer_id));

    }
}
