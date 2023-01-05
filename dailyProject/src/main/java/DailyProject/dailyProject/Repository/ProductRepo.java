package DailyProject.dailyProject.Repository;

import DailyProject.dailyProject.Entity.Comment;
import DailyProject.dailyProject.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {
    public List<Product> findByExDateLessThanEqual(String exDate);
    public List<Product> findByExDateGreaterThanEqual(String exDate);
}
