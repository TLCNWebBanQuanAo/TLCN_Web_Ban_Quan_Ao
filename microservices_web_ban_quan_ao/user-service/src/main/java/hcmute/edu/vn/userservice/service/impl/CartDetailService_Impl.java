package hcmute.edu.vn.userservice.service.impl;

import hcmute.edu.vn.userservice.exception.NotFoundException;
import hcmute.edu.vn.userservice.model.Cart_Detail;
import hcmute.edu.vn.userservice.repository.Cart_Detail_Repository;
import hcmute.edu.vn.userservice.service.CartDetail_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService_Impl implements CartDetail_Service {
    @Autowired
    private Cart_Detail_Repository cart_detail_repository;

    @Override
    public List<Cart_Detail> RetrieveAllProductInCart (int id){
        List<Cart_Detail> cart_details = cart_detail_repository.FindByCartId(id);
        if(cart_details.isEmpty())
            throw new NotFoundException("Your cart is empty !");
        return cart_details;
    }

    @Override
    public Cart_Detail AddProductInCart(Cart_Detail cart_detail){
        return cart_detail_repository.save(cart_detail);
    }

    @Override
    public void DeleteProductInCart(Cart_Detail cart_detail){
        cart_detail_repository.delete(cart_detail);
    }

    @Override
    public boolean DeleteAllProductInCart(int id){
        List<Cart_Detail> cart_details = cart_detail_repository.FindByCartId(id);

        if(cart_details.isEmpty())
            throw new NotFoundException("Your cart is empty !");

        for(Cart_Detail cart_detail:cart_details) {
            DeleteProductInCart(cart_detail);
        }
        return true;
    }

}
