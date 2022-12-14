package net.flexberry.flexberrySampleSpring.controller;

import net.flexberry.flexberrySampleSpring.object.Comment;
import net.flexberry.flexberrySampleSpring.object.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static net.flexberry.flexberrySampleSpring.controller.UserController.usersList;

@RestController
@RequestMapping("/comments")
public class CommentController {
    public static List<Comment> commentsList = new ArrayList<>();

    public Comment createComment(int id, String text, User user){
        Comment comment = new Comment();
        comment.setCommentId(id);
        comment.setText(text);
        comment.setUser(user);
        commentsList.add(comment);
        return comment;
    }

    @PostMapping
    public Comment create(@RequestParam(value = "id", defaultValue = "0") int id,
                       @RequestParam(value = "text", defaultValue = "") String text,
                       @RequestParam(value = "userId", defaultValue = "1") int userId) {
        Comment comment = new Comment();
        comment.setCommentId(id);
        comment.setText(text);
        comment.setUser(getUser(userId));
        commentsList.add(comment);
        return comment;
    }

    @GetMapping("/{id}")
    public Comment getOneComment(@PathVariable int id){
        return getComment(id);
    }

    public User getUser(@PathVariable int id){
        return usersList.stream()
                .filter(user -> user.getUserId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public Comment getComment(@PathVariable int id){
        return commentsList.stream()
                .filter(comment -> comment.getCommentId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @PutMapping("/{id}")
    public synchronized Comment updateComment(@PathVariable int id,
                                        @RequestParam(value = "text", defaultValue = "") String text,
                                        @RequestParam(value = "userId", defaultValue = "0") int userId) {
        Comment oldComment = getComment(id);
        String oldText = oldComment.getText();
        User user = oldComment.getUser();
        deleteComment(id);

        if (text.equals("")) {
            text = oldText;
        }

        if (userId != 0) {
            user = getUser(userId);
        }

        return createComment(id, text, user);
    }

    @GetMapping
    public static List<Comment> getAllComments(){
        return commentsList;
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable int id){
        Comment comment = getComment(id);
        commentsList.remove(comment);
    }
}
