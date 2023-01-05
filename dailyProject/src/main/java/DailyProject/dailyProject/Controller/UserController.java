package DailyProject.dailyProject.Controller;

import DailyProject.dailyProject.Dto.UserDto;
import DailyProject.dailyProject.Entity.Comment;
import DailyProject.dailyProject.Entity.User;
import DailyProject.dailyProject.Service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Users")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/createUser")
    public User createCustomer(@RequestBody UserDto newUser) {
        return userService.createCustomer(newUser);
    }

    @PostMapping("/getOneUserById")
    public User getOneById(Long userId) {
        return userService.getOneById(userId);
    }

    @GetMapping("/getCommentsByUserId")
    public List<Comment> getCommentsByUserId(Long userId){
        return userService.getCommentsByUserId(userId);
    }

}
