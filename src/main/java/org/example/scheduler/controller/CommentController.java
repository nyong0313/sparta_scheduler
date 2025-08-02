package org.example.scheduler.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduler.controller.dto.CommentRequestDto;
import org.example.scheduler.controller.dto.ScheduleRequestDto;
import org.example.scheduler.service.CommentService;
import org.example.scheduler.service.dto.ApiResponse;
import org.example.scheduler.service.dto.CommentResponseDto;
import org.example.scheduler.service.dto.ScheduleResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/schedules/{scheduleId}")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ApiResponse<CommentResponseDto> saveSchedule(@PathVariable Long scheduleId, @RequestBody CommentRequestDto commentRequestDto) {
        return ApiResponse.ok(commentService.saveComment(scheduleId, commentRequestDto));
    }
}
