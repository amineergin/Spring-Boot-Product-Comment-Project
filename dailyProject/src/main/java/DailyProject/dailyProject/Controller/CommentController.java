package DailyProject.dailyProject.Controller;

import DailyProject.dailyProject.Dto.CommentDto;
import DailyProject.dailyProject.Entity.Comment;
import DailyProject.dailyProject.Entity.Product;
import DailyProject.dailyProject.Response.CommentResponse;
import DailyProject.dailyProject.Service.CommentService;
import DailyProject.dailyProject.Service.impl.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Comment")
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/createComment")
    public CommentDto createComment(CommentDto newComment) {
        return commentService.createComment(newComment);
    }
    @GetMapping("/ListAllComments")
    public List<CommentResponse> listAllComments(){
        return commentService.listAllComments();
    }
    @GetMapping("/getCommentByProductId")
    public String deneme(Long productId){
        return commentService.getCommentByProductId(productId);
    }
    @GetMapping("/getCommentsBetweenDateByUserId")
    public List<Comment> getCommentsBetweenDate(Long userId, String startDate, String endDate){
        return commentService.getCommentsBetweenDate(userId,startDate,endDate);
    }
    @GetMapping("/getCommentsBetweenDateByProductId")
    public List<Comment> getCommentsBetweenDateByProductId(Long productId, String startDate, String endDate){
        return commentService.getCommentsBetweenDateByProductId(productId,startDate,endDate);
    }

    @RequestMapping(value = "/lessthanequal/{exDate}", method = RequestMethod.GET)
    @ResponseBody
    //less than equal kendisinden küçük veya eşit olanları getirir, yani tarihi geçmişler için
    public List<Product> findByexDateLessThanEqual(@PathVariable String exDate){
        return commentService.getExpiredProduct(exDate);
    }
    @RequestMapping(value = "/greaterthanequal/{exDate}", method = RequestMethod.GET)
    @ResponseBody
    //greater than equal kendisinden büyükleri getirir, yani tarihi geçmemiş ve nullar için
    public List<Product> findByexDateGreaterThanEqual(@PathVariable String exDate){
        return commentService.getnotExpiredProduct(exDate);
    }
}
