package DailyProject.dailyProject.Service.impl;

import DailyProject.dailyProject.Dto.CommentDto;
import DailyProject.dailyProject.Entity.Comment;
import DailyProject.dailyProject.Entity.Product;
import DailyProject.dailyProject.Entity.User;
import DailyProject.dailyProject.Repository.CommentRepo;
import DailyProject.dailyProject.Repository.ProductRepo;
import DailyProject.dailyProject.Repository.UserRepo;
import DailyProject.dailyProject.Response.CommentResponse;
import DailyProject.dailyProject.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor


public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;
    private final ProductRepo productRepo;
    private final UserRepo userRepo;
    private final UserServiceImpl userService;
    private final ProductServiceImpl productService;
    @Override
    public CommentDto createComment(CommentDto newComment) {
        var product = productRepo.findById(newComment.getProductId()).orElseThrow();
        var user = userRepo.findById(newComment.getUserId()).orElseThrow();
        var comment = Comment.builder()
                .comment(newComment.getComment())
                .commentDate(newComment.getCommentDate())
                .product(product)
                .user(user)
                .build();
            var createdComment = commentRepo.save(comment);
            return CommentDto.convertFromCommentEntity(createdComment);
        }


    @Override
    public List<CommentResponse> listAllComments() {
        List<Comment> commentList;
        commentList = commentRepo.findAll();
        return commentList.stream().map(comment -> new CommentResponse(comment)).collect(Collectors.toList());
    }


    @Override
    public String getCommentByProductId(Long productId) {
        var deneme = commentRepo.findById(productId).orElse(null);
        var denemeliListe = deneme.getComment();
        return denemeliListe;

    }

    private boolean isBetweenDates(String startDate, String endDate, Comment productComment) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date newStartDate ;
        Date newEndDate ;
        try {
            newStartDate = (Date) dateFormat.parse(startDate);
            newEndDate = (Date) dateFormat.parse(endDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return productComment.getCommentDate().after(newStartDate) && productComment.getCommentDate().before(newEndDate);
    }

    @Override
    public List<Comment> getCommentsBetweenDate(Long userId, String startDate, String endDate) {
        var fUserId = userRepo.findById(userId).orElse(null);
        return fUserId.getComment()
                .stream()
                .filter(productComment -> isBetweenDates(startDate, endDate, productComment))
                .collect(Collectors.toList());
    }

    @Override
    public List<Comment> getCommentsBetweenDateByProductId(Long productId, String startDate, String endDate) {
        var fProductId = productRepo.findById(productId).orElse(null);
        return fProductId.getComment()
                .stream()
                .filter(productComment -> isBetweenDates(startDate, endDate, productComment))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getExpiredProduct(String exDate) {
        return productRepo.findByExDateLessThanEqual(exDate);
    }

    @Override
    public List<Product> getnotExpiredProduct(String exDate) {
        return productRepo.findByExDateGreaterThanEqual(exDate);
    }


}
