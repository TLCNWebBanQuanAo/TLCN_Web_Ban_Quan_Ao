package hcmute.edu.vn.guestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hcmute.edu.vn.guestservice.model.Bill;

public interface Bill_Repository extends JpaRepository<Bill, Long>  {
}
