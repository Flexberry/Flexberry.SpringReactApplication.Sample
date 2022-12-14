package net.flexberry.flexberrySampleSpring;

import net.flexberry.flexberrySampleSpring.object.Comment;
import net.flexberry.flexberrySampleSpring.object.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static net.flexberry.flexberrySampleSpring.controller.CommentController.commentsList;
import static net.flexberry.flexberrySampleSpring.controller.UserController.usersList;

@SpringBootApplication
@RestController
public class FlexberrySampleSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(FlexberrySampleSpringApplication.class, args);

		User user1 = new User(1, "name1", 1);
		usersList.add(user1);

		Comment comment1 = new Comment(1, "deep meaningful comment", user1);
		commentsList.add(comment1);
	}

	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

}
