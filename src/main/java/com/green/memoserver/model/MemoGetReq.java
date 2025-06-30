package com.green.memoserver.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.beans.ConstructorProperties;

// @Builder
@Getter
@ToString
public class MemoGetReq {
    private String searchText;
    private Integer page;

    @ConstructorProperties({"search_text", "page"})
    public MemoGetReq(String searchText, Integer page) {
        this.searchText = searchText;
        this.page = page;
    }
}
