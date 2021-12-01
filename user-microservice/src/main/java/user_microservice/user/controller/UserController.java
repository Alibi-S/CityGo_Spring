package user_microservice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import user_microservice.user.model.Log;
import user_microservice.user.model.User;
import user_microservice.user.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("")
    public List<User> findAllUsers(){return userService.findAllUsers();}

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable Long id) {return userService.findUserById(id);}

    @GetMapping("/names/{name}")
    public Optional<User> findUserByName(@PathVariable String name){return userService.findUserByName(name);}

    @GetMapping("/emails/{email}")
    public Optional<User> findUserByEmail(@PathVariable String email){return userService.findUserByEmail(email);}

    @PostMapping("/register")
    public void createUser(@RequestBody User user) { //
        //User user = new User(new Long(1), "Riddle for eureka???", "Answer!!!!", new Long(1), java.util.Calendar.getInstance().getTime(), java.util.Calendar.getInstance().getTime());
        userService.createUser(user);
        Log log = new Log(1,"UserService", "POST", user.toString());

        HttpEntity<Log> request = new HttpEntity<>(log);
        restTemplate.postForObject("http://logging-api/logs", request, Log.class);

        System.out.println(log.toString());
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
        Log log = new Log(1,"UserService", "UPDATE", user.toString());

        HttpEntity<Log> request = new HttpEntity<>(log);
        restTemplate.postForObject("http://logging-api/logs", request, Log.class);

        System.out.println(log.toString());
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
        Log log = new Log(1,"UserService", "DELETE", user.toString());

        HttpEntity<Log> request = new HttpEntity<>(log);
        restTemplate.postForObject("http://logging-api/logs", request, Log.class);

        System.out.println(log.toString());
    }


}
