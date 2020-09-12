package com.ccnu.paper_service.service;

import com.ccnu.paper_service.model.entity.AccuserDocument;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 15:01 2020/7/14
 */
public interface AccuserDocumentService {
    List<AccuserDocument> findByAccuserId(Integer accuserId);


}
