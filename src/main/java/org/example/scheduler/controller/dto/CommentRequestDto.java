package org.example.scheduler.controller.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private String writerName;
    private String password;
    private String content;
}
