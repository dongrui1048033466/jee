package com.drsoft.JEE.utils;

import java.util.List;

public class Page<T> {
    //总条数
    private Integer total;
    //当前页
    private Integer page;
    //每页数
    private Integer size;
    //结果集
    private List<T> rows;

    public int getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
