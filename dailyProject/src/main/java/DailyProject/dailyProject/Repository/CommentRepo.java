package DailyProject.dailyProject.Repository;

import DailyProject.dailyProject.Entity.Comment;
import DailyProject.dailyProject.Response.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {
}
