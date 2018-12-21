package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.userservice.model.Product;
import hcmute.edu.vn.userservice.model.Type;
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
public interface Type_Repository extends JpaRepository<Type, Integer> {
}
