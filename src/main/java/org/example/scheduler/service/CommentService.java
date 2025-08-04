package org.example.scheduler.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduler.controller.dto.CommentRequestDto;
import org.example.scheduler.entity.Comment;
import org.example.scheduler.entity.Schedule;
import org.example.scheduler.repository.CommentRepository;
import org.example.scheduler.repository.ScheduleRepository;
import org.example.scheduler.service.dto.CommentResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponseDto saveComment(Long scheduleId, CommentRequestDto commentRequestDto) {
        Schedule existingSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("일정을 찾을 수 없습니다. id: " + scheduleId));

        if(existingSchedule.getComments().size() >= 10)
            throw new IllegalStateException("댓글은 최대 10개까지만 작성할 수 있습니다.");

        Comment comment = new Comment(
                commentRequestDto.getWriterName(),
                commentRequestDto.getPassword(),
                commentRequestDto.getContent()
        );

        comment.setSchedule(existingSchedule);
        commentRepository.save(comment);

        return CommentResponseDto.from(comment);
    }
}
