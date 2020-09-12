package com.ccnu.paper_service.controller;

import com.ccnu.paper_service.service.AccuserDocumentService;
import com.ccnu.paper_service.utils.JsonData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 15:05 2020/7/14
 */
@RestController
@RequestMapping("/api/v1/pri/document")
public class AccuserDocumentController {
    @Autowired
    private AccuserDocumentService accuserDocumentService;
    @RequestMapping("/findDocumentByAccuserId")
    public JsonData findDocumentByAccuserId(@Param("accuser_id") int accuserId)
    {
        return JsonData.buildSuccess(accuserDocumentService.findByAccuserId(accuserId));
    }

}
