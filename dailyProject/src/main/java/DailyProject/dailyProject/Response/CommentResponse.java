package DailyProject.dailyProject.Response;

import DailyProject.dailyProject.Entity.Comment;
import lombok.Data;

import java.sql.Date;

@Data
public class CommentResponse {
    private String comment;
    private Date commentDate;

        public CommentResponse(Comment entity){
            this.comment = entity.getComment();
            this.commentDate = entity.getCommentDate();
        }
}
