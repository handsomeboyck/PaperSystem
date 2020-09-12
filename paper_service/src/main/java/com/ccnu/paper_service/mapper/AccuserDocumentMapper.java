package com.ccnu.paper_service.mapper;

import com.ccnu.paper_service.model.entity.AccuserDocument;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 14:54 2020/7/14
 */
public interface AccuserDocumentMapper {
    //根据原告查询文书列表
    List<AccuserDocument> findByAccuserId(@Param("accuser_id") Integer accuserId);

}
