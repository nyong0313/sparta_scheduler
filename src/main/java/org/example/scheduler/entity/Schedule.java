package org.example.scheduler.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public Schedule(String title, String writerName, String password, String content) {
        this.title = title;
        this.writerName = writerName;
        this.password = password;
        this.content = content;
    }

    public void updateSchedule(String title, String writerName) {
        this.title = title;
        this.writerName = writerName;
    }
}
