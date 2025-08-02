package org.example.scheduler.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writerName;
    private String password;
    private String content;

    public Comment (String writerName, String password, String content) {
        this.writerName = writerName;
        this.password = password;
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
        // 양방향 동기화
        schedule.getComments().add(this);
    }
}
