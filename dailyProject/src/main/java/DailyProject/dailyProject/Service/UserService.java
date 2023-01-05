package DailyProject.dailyProject.Service;

import DailyProject.dailyProject.Dto.UserDto;
import DailyProject.dailyProject.Entity.Comment;
import DailyProject.dailyProject.Entity.User;

import java.util.List;

public interface UserService {
    public User createCustomer(UserDto newUser);
    public User getOneById(Long userId);
    public List<Comment> getCommentsByUserId(Long userId);

}
