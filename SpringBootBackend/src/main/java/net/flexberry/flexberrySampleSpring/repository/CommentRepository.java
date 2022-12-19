package net.flexberry.flexberrySampleSpring.repository;

import net.flexberry.flexberrySampleSpring.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends RevisionRepository<Comment, Integer, Integer>, JpaRepository<Comment, Integer> {
}
