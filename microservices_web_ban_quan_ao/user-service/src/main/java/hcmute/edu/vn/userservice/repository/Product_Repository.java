package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.guestservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Product_Repository extends JpaRepository<Product, Long> {
}
