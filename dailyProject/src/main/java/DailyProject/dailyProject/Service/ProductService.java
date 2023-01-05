package DailyProject.dailyProject.Service;

import DailyProject.dailyProject.Dto.ProductDto;
import DailyProject.dailyProject.Entity.Comment;
import DailyProject.dailyProject.Entity.Product;

import java.util.List;

public interface ProductService {
    public Product createProduct(ProductDto newProduct);
    public Product getOneById(Long productId);
}
