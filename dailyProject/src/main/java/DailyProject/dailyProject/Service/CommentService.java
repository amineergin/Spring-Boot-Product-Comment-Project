package DailyProject.dailyProject.Service;

import DailyProject.dailyProject.Dto.CommentDto;
import DailyProject.dailyProject.Entity.Comment;
import DailyProject.dailyProject.Entity.Product;
import DailyProject.dailyProject.Response.CommentResponse;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    public CommentDto createComment(CommentDto newComment);
    public List<CommentResponse> listAllComments();
    public String getCommentByProductId(Long productId);
    public List<Comment> getCommentsBetweenDate(Long userId, String startDate, String endDate);
    public List<Comment> getCommentsBetweenDateByProductId(Long productId, String startDate, String endDate);
    public List<Product> getExpiredProduct(String exDate);
    public List<Product> getnotExpiredProduct(String exDate);
}
