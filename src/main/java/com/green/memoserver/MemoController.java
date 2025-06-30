package com.green.memoserver;

import com.green.memoserver.config.model.ResultResponse;
import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/memo")
public class MemoController {
    private final MemoService memoService;

    // Create
    // (post) /api/memo,
    @PostMapping
    public ResultResponse<Integer> postMemo(@RequestBody MemoPostReq req) {
        log.info("req={}", req);
        int result = memoService.save(req);
        return new ResultResponse<>("삽입 성공", result);
    }

    // Read
    // (get)
    @GetMapping
    public ResultResponse<List<MemoGetRes>> getMemo(@ModelAttribute MemoGetReq req) {
        log.info("req={}", req);
        List<MemoGetRes> result = memoService.findAll(req);
        String message = String.format("rows: %d", result.size());
        return new ResultResponse<>(message, result);
    }

    @GetMapping("{memoId}")
    public ResultResponse<MemoGetOneRes> getMemoId(@PathVariable int memoId) {
        log.info("memoId={}", memoId);
        MemoGetOneRes result = memoService.findById(memoId);
        return new ResultResponse<>("조회 성공", result);
    }

    // Update
    // (put, patch)
    @PutMapping
    public ResultResponse<Integer> putMemo(@RequestBody MemoPutReq req) {
        log.info("req={}", req);
        int result = memoService.modify(req);
        return new ResultResponse<>("수정 성공", result);

    }

    // Delete
    // (delete)
    @DeleteMapping
    public ResultResponse<Integer> deleteMemo(@RequestParam("memo_id")int id) {
        log.info("id={}", id);
        int result = memoService.deleteById(id);
        return new ResultResponse<>("삭제 성공", result);
    }

}
