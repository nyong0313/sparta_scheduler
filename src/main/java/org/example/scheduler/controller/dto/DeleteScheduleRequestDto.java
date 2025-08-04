package org.example.scheduler.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class DeleteScheduleRequestDto {
    @NotBlank
    private String password;
}
