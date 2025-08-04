package org.example.scheduler.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    @NotBlank
    @Size(max = 30)
    private String title;

    @NotBlank
    private String writerName;

    @NotBlank
    private String password;

    @NotBlank
    @Size(max = 200)
    private String content;
}
