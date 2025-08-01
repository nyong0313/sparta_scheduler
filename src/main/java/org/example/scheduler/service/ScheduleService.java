package org.example.scheduler.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduler.controller.dto.ScheduleRequestDto;
import org.example.scheduler.entity.Schedule;
import org.example.scheduler.repository.ScheduleRepository;
import org.example.scheduler.service.dto.ScheduleResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(
                scheduleRequestDto.getTitle(),
                scheduleRequestDto.getWriterName(),
                scheduleRequestDto.getPassword(),
                scheduleRequestDto.getContent()
        );

        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getWriterName(),
                savedSchedule.getContent(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getUpdatedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> getSchedules() {
        // findAll 반환값은 List
        List<Schedule> scheduleList = scheduleRepository.findAll();
        List<ScheduleResponseDto> scheduleResponseDtoList = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            scheduleResponseDtoList.add(new ScheduleResponseDto(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getWriterName(),
                    schedule.getContent(),
                    schedule.getCreatedAt(),
                    schedule.getUpdatedAt()
            ));
        }
        return scheduleResponseDtoList;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다. id: " + id));
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getWriterName(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        );
    }
}
