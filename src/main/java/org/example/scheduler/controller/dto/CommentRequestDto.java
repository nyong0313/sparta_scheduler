package org.example.scheduler.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CommentRequestDto {
    @NotBlank
    private String writerName;

    @NotBlank
    private String password;

    @NotBlank
    @Size(max = 100)
    private String content;
}
