package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT COUNT(c.name) FROM Category c")
    Integer countGives();
}
