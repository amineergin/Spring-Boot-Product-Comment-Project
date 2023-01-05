package DailyProject.dailyProject.Controller;

import DailyProject.dailyProject.Dto.ProductDto;
import DailyProject.dailyProject.Entity.Product;
import DailyProject.dailyProject.Service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Product")
public class ProductController {
    private final ProductServiceImpl productService;

    @PostMapping("/createProduct")
    public Product createProduct(ProductDto newProduct) {
        return productService.createProduct(newProduct);
    }

    @PostMapping("/getOneProductById")
    public Product getOneById(Long productId) {
        return productService.getOneById(productId);
    }

}
