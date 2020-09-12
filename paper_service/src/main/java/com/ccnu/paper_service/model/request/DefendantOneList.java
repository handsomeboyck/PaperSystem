package com.ccnu.paper_service.model.request;

import com.ccnu.paper_service.model.entity.DefendantOne;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 22:51 2020/8/10
 */
public class DefendantOneList {
    private List<DefendantOne> defendantOneList;

    public List<DefendantOne> getDefendantOneList() {
        return defendantOneList;
    }

    public void setDefendantOneList(List<DefendantOne> defendantOneList) {
        this.defendantOneList = defendantOneList;
    }
}
