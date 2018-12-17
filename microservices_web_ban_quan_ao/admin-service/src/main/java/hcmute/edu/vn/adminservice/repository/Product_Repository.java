package hcmute.edu.vn.adminservice.repository;

import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Product_Repository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(int Id);
    List<Product> findAll();
}
