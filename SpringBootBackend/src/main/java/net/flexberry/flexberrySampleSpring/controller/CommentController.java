package net.flexberry.flexberrySampleSpring.controller;

import net.flexberry.flexberrySampleSpring.model.Comment;
import net.flexberry.flexberrySampleSpring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    CommentService service;

    @GetMapping("/comments/{primarykey}")
    public Comment getComment(@PathVariable("primarykey") int primaryKey) {
        return service.getCommnet(primaryKey);
    }

    @DeleteMapping("/comments/{primaryKey}")
    public void deleteComment(@PathVariable("primaryKey") int primaryKey) {
        service.deleteCommentByPrimaryKey(primaryKey);
    }

    @PostMapping("/comments")
    public void addComment(@RequestBody Comment comment) {
        service.saveOrUpdateComment(comment);
    }

    @PutMapping("/comments")
    public void updateComment(@RequestBody Comment comment) {
        service.saveOrUpdateComment(comment);
    }
}
