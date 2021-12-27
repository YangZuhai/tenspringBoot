package com.hxzyyn.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class PageTwo {

    public int getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNumberAll() {
        return numberAll;
    }

    public void setNumberAll(int numberAll) {
        this.numberAll = numberAll;
    }

    public int getPageAll() {
        return pageAll;
    }


    public void setPageAll(int numberAll) {
        if (numberAll != 0) {
            this.numberAll = numberAll;
            this.pageAll = this.numberAll % this.pageSize == 0
                    ? (this.numberAll / this.pageSize)
                    : (this.numberAll / this.pageSize + 1);
        }

    }

    public List<Integer> getStartList() {
        return startList;
    }

    public void setStartList(List<Integer> startList) {
        this.startList = startList;
    }

    //    计算页码集合
    public void setAllPageStart(int currPageNo, int pageAll) {
        this.currPageNo = currPageNo;
        this.pageAll = pageAll;
//        每一次迭代数量
        int length = 3;
        int start = this.currPageNo - 1;
        if (this.currPageNo == this.pageAll) {
            start = this.currPageNo - 2;
        }
//        显示的起始页码大于等于0时true 返回1 否则false 返回自身
        start = start <= 0 ? 1 : start;
        for (int i = 0; i < Math.min(this.pageAll, length); i++) {
            this.startList.add((start));
            start++;
        }
    }


    //    起始页
    private int currPageNo;

    //    每页展示数据条数
    private int pageSize;

    //    数据总条数
    private int numberAll;

    //    总页数
    private int pageAll;

    //    页码集合
    private List<Integer> startList;
}
