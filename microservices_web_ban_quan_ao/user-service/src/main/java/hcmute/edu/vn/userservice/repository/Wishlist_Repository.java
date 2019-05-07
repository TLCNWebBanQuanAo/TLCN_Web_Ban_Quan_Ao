package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.userservice.model.Wishlist;
import hcmute.edu.vn.userservice.model.Wishlist_Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface Wishlist_Repository extends JpaRepository<Wishlist, Wishlist_Id> {
    @Query(value="SELECT * FROM public.wishlist up WHERE up.product_id = ?1", nativeQuery=true)
    List<Wishlist_Id> findAllByProduct_Id(long id);

    @Query(value="SELECT * FROM public.wishlist up WHERE up.user_id = ?1", nativeQuery=true)
    List<Wishlist> findAllByUserId(long id);

    @Query(value="DELETE FROM public.wishlist up WHERE up.user_id = ?1", nativeQuery=true)
    void deleteAllByUserId(long id);

}
