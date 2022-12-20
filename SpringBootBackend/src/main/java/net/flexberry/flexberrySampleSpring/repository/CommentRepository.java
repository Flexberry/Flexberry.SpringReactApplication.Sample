package net.flexberry.flexberrySampleSpring.repository;

import net.flexberry.flexberrySampleSpring.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository extends RevisionRepository<Comment, UUID, Integer>, JpaRepository<Comment, UUID> {
}
