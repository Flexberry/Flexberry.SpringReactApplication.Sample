package net.flexberry.flexberrySampleSpring.Controllers;

import net.flexberry.flexberrySampleSpring.Objects.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    public static List<User> usersList = new ArrayList<>();

    public User createUser(int id, String name, int age){
        User user = new User();
        user.setUserId(id);
        user.setUserName(name);
        user.setAge(age);
        usersList.add(user);
        return user;
    }

    @PostMapping
    public User create(@RequestParam(value = "id", defaultValue = "0") int id,
                       @RequestParam(value = "name", defaultValue = "emptyName") String name,
                       @RequestParam(value = "age", defaultValue = "0") int age) {
        User user = new User();
        user.setUserId(id);
        user.setUserName(name);
        user.setAge(age);
        usersList.add(user);
        return user;
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable int id){
        return getUser(id);
    }

    public User getUser(@PathVariable int id){
        return usersList.stream()
                .filter(user -> user.getUserId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @PutMapping("/{id}")
    public synchronized User updateUser(@PathVariable int id,
                                        @RequestParam(value = "name", defaultValue = "emptyName") String name,
                                        @RequestParam(value = "age", defaultValue = "0") int age) {
        User oldUser = getUser(id);
        String oldName = oldUser.getUserName();
        int oldAge = oldUser.getAge();
        deleteUser(id);

        if (name.equals("emptyName")) {
            name = oldName;
        }

        if (age == 0) {
            age = oldAge;
        }

        return createUser(id, name, age);
    }

    @GetMapping
    public static List<User> getAllUsers(){
        return usersList;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        User user = getUser(id);
        usersList.remove(user);
    }}
