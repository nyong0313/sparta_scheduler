package org.example.scheduler.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduler.controller.dto.DeleteScheduleRequestDto;
import org.example.scheduler.controller.dto.ScheduleRequestDto;
import org.example.scheduler.controller.dto.UpdateScheduleRequestDto;
import org.example.scheduler.service.ScheduleService;
import org.example.scheduler.service.dto.ApiResponse;
import org.example.scheduler.service.dto.ScheduleResponseDto;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{scheduleId}")
    public ApiResponse<ScheduleResponseDto> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleRequestDto updateScheduleRequestDto)
    {
        return ApiResponse.ok(scheduleService.updateScheduleById(scheduleId, updateScheduleRequestDto));
    }

    @DeleteMapping("/{scheduleId}")
    public ApiResponse<ScheduleResponseDto> deleteSchedule(
            @PathVariable Long scheduleId,
            @RequestBody DeleteScheduleRequestDto deleteScheduleRequestDto)
    {
        scheduleService.deleteScheduleById(scheduleId, deleteScheduleRequestDto);
        return ApiResponse.of(HttpStatus.OK, "일정이 삭제되었습니다. ID: " + scheduleId);
    }
}
