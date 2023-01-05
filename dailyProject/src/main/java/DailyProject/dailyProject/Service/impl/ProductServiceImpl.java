package DailyProject.dailyProject.Service.impl;

import DailyProject.dailyProject.Dto.ProductDto;
import DailyProject.dailyProject.Entity.Comment;
import DailyProject.dailyProject.Entity.Product;
import DailyProject.dailyProject.Repository.ProductRepo;
import DailyProject.dailyProject.Repository.UserRepo;
import DailyProject.dailyProject.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    @Override
    public Product createProduct(ProductDto newProduct) {
        Product product = new Product();
        product.setId(newProduct.getProductId());
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        product.setExDate(newProduct.getExDate());
        return productRepo.save(product);
    }

    @Override
    public Product getOneById(Long productId) {
        return productRepo.findById(productId).orElse(null);
    }

}
