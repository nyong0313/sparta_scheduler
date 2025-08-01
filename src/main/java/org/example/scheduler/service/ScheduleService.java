package org.example.scheduler.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduler.controller.dto.ScheduleRequestDto;
import org.example.scheduler.entity.Schedule;
import org.example.scheduler.repository.ScheduleRepository;
import org.example.scheduler.service.dto.ScheduleResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
