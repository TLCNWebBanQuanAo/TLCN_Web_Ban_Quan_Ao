package hcmute.edu.vn.userservice.service;

import hcmute.edu.vn.userservice.model.Cart_Detail;

import java.util.List;

public interface CartDetail_Service {
    List<Cart_Detail> RetrieveAllProductInCart (int id);
    Cart_Detail AddProductInCart(Cart_Detail cart_detail);
    void DeleteProductInCart(Cart_Detail cart_detail);
    boolean DeleteAllProductInCart(int id);
}


