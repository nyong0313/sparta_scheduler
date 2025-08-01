package org.example.scheduler.controller.dto;

import lombok.Getter;
import org.example.scheduler.entity.Comment;

import java.util.List;

@Getter
public class ScheduleRequestDto {
    private String title;
    private String writerName;
    private String password;
    private String content;
}
