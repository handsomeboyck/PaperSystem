package com.ccnu.paper_service.model.response;

import com.ccnu.paper_service.model.entity.DefendantOne;

import java.util.List;

/**
 * @Author: ck
 * @Description:
 * @Date: Create in 17:12 2020/9/4
 */
public class DefendantOneResponse {
    private int count;
    private List<DefendantOne> defendantOneList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DefendantOne> getDefendantOneList() {
        return defendantOneList;
    }

    public void setDefendantOneList(List<DefendantOne> defendantOneList) {
        this.defendantOneList = defendantOneList;
    }
}
