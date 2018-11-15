package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.userservice.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Bill_Repository extends JpaRepository<Bill, Long>  {
    Optional<Bill> FindById(int id);
}
