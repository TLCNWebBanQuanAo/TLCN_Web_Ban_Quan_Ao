package hcmute.edu.vn.adminservice.repository;

import hcmute.edu.vn.adminservice.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Type_Repository extends JpaRepository<Type, Integer> {
    Optional<Type> findById(int Id);
    List<Type> findAll();
}
