package hcmute.edu.vn.adminservice.repository;

import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.model.SaleOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleOff_Repository extends JpaRepository<SaleOff, Integer> {
    Optional<SaleOff> findById(int Id);
    List<SaleOff> findAll();
}
