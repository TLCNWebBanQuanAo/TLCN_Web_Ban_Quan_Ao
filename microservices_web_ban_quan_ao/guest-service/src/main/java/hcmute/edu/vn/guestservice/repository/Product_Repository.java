package hcmute.edu.vn.guestservice.repository;

import hcmute.edu.vn.guestservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface Product_Repository extends JpaRepository<Product, Long> {
    Optional<Product> findById(long id);
}
