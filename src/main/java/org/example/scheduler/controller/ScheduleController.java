package org.example.scheduler.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduler.controller.dto.ScheduleRequestDto;
import org.example.scheduler.service.ScheduleService;
import org.example.scheduler.service.dto.ScheduleResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ScheduleResponseDto saveSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        return scheduleService.saveSchedule(scheduleRequestDto);
    }

    @GetMapping
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleService.getSchedules();
    }

    @GetMapping("/{scheduleId}")
    public ScheduleResponseDto getScheduleById(@PathVariable Long scheduleId) {
        return scheduleService.getScheduleById(scheduleId);
    }
}
