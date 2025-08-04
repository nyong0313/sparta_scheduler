package org.example.scheduler.service.dto;

import lombok.Getter;
import org.example.scheduler.entity.Comment;
import org.example.scheduler.entity.Schedule;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String title;
    private final String writerName;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final List<CommentResponseDto> commentResponseDtos;

    public ScheduleResponseDto(
            Long id,
            String title,
            String writerName,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            List<CommentResponseDto> commentResponseDtos) {
        this.id = id;
        this.title = title;
        this.writerName = writerName;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.commentResponseDtos = commentResponseDtos;
    }

    public static ScheduleResponseDto from(Schedule schedule) {
        List<CommentResponseDto> commentResponseDtos = schedule.getComments()
                .stream()
                .map(CommentResponseDto::from)
                .collect(Collectors.toList());

        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getWriterName(),
                schedule.getContent(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt(),
                commentResponseDtos
        );
    }
}
