package org.example.scheduler.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.scheduler.controller.dto.CommentRequestDto;
import org.example.scheduler.service.CommentService;
import org.example.scheduler.service.dto.ApiResponse;
import org.example.scheduler.service.dto.CommentResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/schedules/{scheduleId}")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ApiResponse<CommentResponseDto> saveSchedule(@PathVariable Long scheduleId, @Valid @RequestBody CommentRequestDto commentRequestDto) {
        return ApiResponse.ok(commentService.saveComment(scheduleId, commentRequestDto));
    }
}
