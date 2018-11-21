package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.userservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Product_Repository extends JpaRepository<Product, Long> {
    Optional<Product> FindById(int id);
}
