package hcmute.edu.vn.adminservice.repository;

import hcmute.edu.vn.adminservice.model.Wishlist;
import hcmute.edu.vn.adminservice.model.Wishlist_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface Wishlist_Repository extends JpaRepository<Wishlist, Wishlist_Id> {
    @Query(value="SELECT * FROM public.wishlist up WHERE up.product_id = ?1", nativeQuery=true)
    List<Wishlist> findAllByProduct_Id(int id);

}
