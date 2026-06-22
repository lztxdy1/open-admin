package com.openadmin.common.core;

public class PageQuery {
    private long pageNum = 1;
    private long pageSize = 10;
    private String keyword;
    public long getPageNum() { return pageNum; }
    public void setPageNum(long pageNum) { this.pageNum = pageNum; }
    public long getPageSize() { return pageSize; }
    public void setPageSize(long pageSize) { this.pageSize = pageSize; }
    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }
}
