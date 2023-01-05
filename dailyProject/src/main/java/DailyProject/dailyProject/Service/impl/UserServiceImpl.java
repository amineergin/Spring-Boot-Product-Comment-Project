package DailyProject.dailyProject.Service.impl;

import DailyProject.dailyProject.Dto.UserDto;
import DailyProject.dailyProject.Entity.Comment;
import DailyProject.dailyProject.Entity.User;
import DailyProject.dailyProject.Repository.UserRepo;
import DailyProject.dailyProject.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User createCustomer(UserDto newUser) {
        User user = new User();
        user.setId(newUser.getUserId());
        user.setName(newUser.getName());
        user.setSurname(newUser.getSurname());
        user.setMail(newUser.getMail());
        user.setPhoneNumber(newUser.getPhoneNumber());
        return userRepo.save(user);
    }

    @Override
    public User getOneById(Long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    @Override
    public List<Comment> getCommentsByUserId(Long userId) {
        var fUserId = userRepo.findById(userId).orElse(null);
        return fUserId.getComment();
    }
}
