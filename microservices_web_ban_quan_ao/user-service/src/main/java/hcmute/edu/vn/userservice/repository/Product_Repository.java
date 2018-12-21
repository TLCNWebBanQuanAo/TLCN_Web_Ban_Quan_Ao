package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.userservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
@Transactional
@Repository
public interface Product_Repository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(int id);
    @Query(value = "SELECT p FROM products p WHERE p.name LIKE CONCAT('%',:keyword,'%')")
    Page<Product> findAllProductsPaging(@Param("keyword") String keyword, Pageable pageable);

    @Query(value = "SELECT p FROM products p WHERE p.name LIKE CONCAT('%',:keyword,'%') and p.status = 1 AND p.type.id = :id")
    Page<Product> findAllProductsByCategoryPaging(@Param("id") int id ,@Param("keyword") String keyword, Pageable pageable);
}
