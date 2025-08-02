package org.example.scheduler.service.dto;

import lombok.Getter;
import org.example.scheduler.controller.dto.CommentRequestDto;
import org.example.scheduler.entity.Comment;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private final Long id;
    private final String writerName;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public CommentResponseDto(
            Long id,
            String writerName,
            String content,
            LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.writerName = writerName;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static CommentResponseDto from(Comment comment) {
        return new CommentResponseDto(
                comment.getId(),
                comment.getWriterName(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }
}
