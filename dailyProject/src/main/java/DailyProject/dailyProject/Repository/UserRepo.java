package DailyProject.dailyProject.Repository;

import DailyProject.dailyProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
