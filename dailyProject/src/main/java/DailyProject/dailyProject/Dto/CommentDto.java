package DailyProject.dailyProject.Dto;

import DailyProject.dailyProject.Entity.Comment;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private Long commentId;
    private String comment;
    private Date commentDate;
    private Long productId;
    private Long userId;
    public Comment fromCommentDto(){
        Comment newComment = new Comment();
        newComment.setId(this.commentId);
        newComment.setComment(this.comment);
        newComment.setCommentDate(this.commentDate);

        return newComment;
    }
    public static CommentDto convertFromCommentEntity(Comment comment){
        return CommentDto.builder()
                .commentId(comment.getId())
                .commentDate(comment.getCommentDate())
                .comment(comment.getComment())
                .productId(comment.getProduct().getId())
                .userId(comment.getUser().getId()).build();
    }


}
