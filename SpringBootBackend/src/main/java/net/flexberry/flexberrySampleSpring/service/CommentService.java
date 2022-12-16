package net.flexberry.flexberrySampleSpring.service;

import net.flexberry.flexberrySampleSpring.model.Comment;
import net.flexberry.flexberrySampleSpring.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository repository;

    public Comment getCommnet(int primarykey) {
        return repository.findById(primarykey).get();
    }

    public void saveOrUpdateComment(Comment comment) {
        repository.save(comment);
    }

    public void deleteCommentByPrimaryKey(int primarykey) {
        repository.deleteById(primarykey);
    }
}
