package org.example.scheduler.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    @NotBlank
    @Size(max = 30)
    private String title;

    @NotBlank
    private String writerName;

    @NotBlank
    private String password;
}
