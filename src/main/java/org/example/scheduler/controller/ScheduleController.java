package org.example.scheduler.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduler.controller.dto.ScheduleRequestDto;
import org.example.scheduler.service.ScheduleService;
import org.example.scheduler.service.dto.ApiResponse;
import org.example.scheduler.service.dto.ScheduleResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ApiResponse<ScheduleResponseDto> saveSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        return ApiResponse.ok(scheduleService.saveSchedule(scheduleRequestDto));
    }

    @GetMapping
    public ApiResponse<List<ScheduleResponseDto>> getSchedules() {
        return ApiResponse.ok(scheduleService.getSchedules());
    }

    @GetMapping("/{scheduleId}")
    public ApiResponse<ScheduleResponseDto> getScheduleById(@PathVariable Long scheduleId) {
        return ApiResponse.ok(scheduleService.getScheduleById(scheduleId));
    }
}
