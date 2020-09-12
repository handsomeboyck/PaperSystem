package com.ccnu.paper_service.service.ServiceImpl;

import com.ccnu.paper_service.mapper.AccuserDocumentMapper;
import com.ccnu.paper_service.model.entity.AccuserDocument;
import com.ccnu.paper_service.service.AccuserDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 15:03 2020/7/14
 */
@Service
public class AccuserDocumentServiceImpl implements AccuserDocumentService {

    @Autowired
   private AccuserDocumentMapper accuserDocumentMapper;

    @Override
    public List<AccuserDocument> findByAccuserId(Integer accuserId) {
        return accuserDocumentMapper.findByAccuserId(accuserId);
    }
}
