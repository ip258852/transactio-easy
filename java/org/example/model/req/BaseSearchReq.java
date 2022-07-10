package org.example.model.req;

public class BaseSearchReq {

    private Integer limit = 50;
    private Integer offset = 0;

    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
