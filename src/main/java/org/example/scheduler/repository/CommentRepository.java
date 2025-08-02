package org.example.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.scheduler.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
