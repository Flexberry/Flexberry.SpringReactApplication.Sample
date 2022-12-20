package net.flexberry.flexberrySampleSpring.service;

import net.flexberry.flexberrySampleSpring.model.Comment;
import net.flexberry.flexberrySampleSpring.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    CommentRepository repository;

    public Comment getCommnet(UUID primarykey) {
        return repository.findById(primarykey).orElse(null);
    }

    public void saveOrUpdateComment(Comment comment) {
        repository.save(comment);
    }

    public void deleteCommentByPrimaryKey(UUID primarykey) {
        repository.deleteById(primarykey);
    }
}
