package com.green.memoserver;

import com.green.memoserver.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    int save(MemoPostReq p);
    List<MemoGetRes> findAll(MemoGetReq req);
    MemoGetOneRes findById(int id);
    int modify(MemoPutReq req);
    int deleteById(int id);
}
