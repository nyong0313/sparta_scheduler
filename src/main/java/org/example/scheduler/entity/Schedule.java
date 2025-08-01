package org.example.scheduler.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String writerName;
    private String password;
    private String content;

    public Schedule(String title, String writerName, String password, String content) {
        this.title = title;
        this.writerName = writerName;
        this.password = password;
        this.content = content;
    }
}
