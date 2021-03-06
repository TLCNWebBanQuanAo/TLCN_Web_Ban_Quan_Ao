package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.userservice.model.Cart_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Cart_Detail_Repository extends JpaRepository<Cart_Detail, Integer> {
    List<Cart_Detail> findById_CartId(Integer id);
}
