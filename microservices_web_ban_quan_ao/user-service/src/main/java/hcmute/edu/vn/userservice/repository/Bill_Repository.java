package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.guestservice.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bill_Repository extends JpaRepository<Bill, Long>  {
}
