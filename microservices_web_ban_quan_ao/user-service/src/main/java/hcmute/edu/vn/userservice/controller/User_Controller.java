package hcmute.edu.vn.userservice.controller;

import hcmute.edu.vn.userservice.api.v1.DataReturnList;
import hcmute.edu.vn.userservice.api.v1.DataReturnRecord;
import hcmute.edu.vn.userservice.api.v1.dto.*;
import hcmute.edu.vn.userservice.api.v1.mapper.*;
import hcmute.edu.vn.userservice.model.*;
import hcmute.edu.vn.userservice.repository.Wishlist_Repository;
import hcmute.edu.vn.userservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/user/")
@CrossOrigin(origins = "http://localhost:4200")
public class User_Controller {
    @Autowired
    private User_Service user_service;
    @Autowired
    private Type_Service type_service;

    @Autowired
    private User_Mapper user_mapper;

    @Autowired
    private Bill_Service bill_service;

    @Autowired
    private Bill_Mapper bill_mapper;

    @Autowired
    private CartDetail_Service cartDetail_service;

    @Autowired
    private CartDetail_Mapper cartDetail_mapper;

    @Autowired
    private Product_Service product_service;

    @Autowired
    private Product_Mapper product_mapper;
    @Autowired
    private Type_Mapper type_mapper;

    @Autowired
    private BillDetail_Service billDetail_service;

    @Autowired
    private Wishlist_Repository wishlist_repository;

    @PostMapping("/changeavatar")
    public DataReturnRecord<User_Dto> changeavatar(@RequestBody User user){
        DataReturnRecord<User_Dto> dataReturnRecord = new DataReturnRecord<>();
        User usertemp= user_service.FindByAccountName(user.getAccountName());
        usertemp.setAvatar(user.getAvatar());
        dataReturnRecord.setData(user_mapper.UserToUserDto(user_service.ChangePassword(usertemp)));
        dataReturnRecord.setMessage("Change Avatar successfully !!!");
        return dataReturnRecord;
    }

    @PostMapping("/changepassword/{accountname}/{oldpassword}/{newpassword}")
    public DataReturnRecord<User_Dto> ChangePassWord(@PathVariable String accountname,
                                                     @PathVariable String oldpassword, @PathVariable String newpassword){
        DataReturnRecord<User_Dto> dataReturnRecord = new DataReturnRecord<>();
        User user = user_service.FindByAccountNameAndPassword(accountname, oldpassword);
        dataReturnRecord.setMessage("Change password successfully.");
        user.setPassword(newpassword);
        dataReturnRecord.setData(user_mapper.UserToUserDto(user_service.ChangePassword(user)));

        return dataReturnRecord;
    }

    @PostMapping("/changepersonalinformation")
    public DataReturnRecord<User_Dto> ChangePersonalInformation(@RequestBody User user){

        DataReturnRecord<User_Dto> dataReturnRecord = new DataReturnRecord<>();
        User user1 = user_service.FindByAccountName(user.getAccountName());
        Date date = new Date();

        user1.setUserUpdate(user1.getAccountName());
        user1.setDateUpdate(date);
        user1.setPassword(user.getPassword());
        user1.setAddress(user.getAddress());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        user1.setDateOfBirth(user.getDateOfBirth());
        user1.setGender(user.getGender());

        dataReturnRecord.setData(user_mapper.UserToUserDto(user_service.ChangePersonalInformation(user1)));
        dataReturnRecord.setMessage("Change personal information successfully.");

        return dataReturnRecord;
    }

    @GetMapping("/{accountname}")
    public DataReturnRecord<User_Dto> GetUser(@PathVariable String accountname){
        DataReturnRecord<User_Dto> dataReturnRecord = new DataReturnRecord<>();

        User user = user_service.FindByAccountName(accountname);
        dataReturnRecord.setMessage("Get User By User Name");
        dataReturnRecord.setData(user_mapper.UserToUserDto(user));

        return dataReturnRecord;
    }
    @GetMapping("/product/{productid}")
    public DataReturnRecord<Product_Dto> GetProduct(@PathVariable int productid){
        DataReturnRecord<Product_Dto> dataReturnRecord = new DataReturnRecord<>();

        Product product = product_service.FindProductById(productid);
        dataReturnRecord.setMessage("Get Product by id");
        dataReturnRecord.setData(product_mapper.ProductToProductDto(product));

        return dataReturnRecord;
    }


    @GetMapping("/getbill/{id}")
    public DataReturnRecord<Bill_Dto> GetBill(@PathVariable int id){
        DataReturnRecord<Bill_Dto> dataReturnRecord = new DataReturnRecord<>();
        Bill bill = bill_service.FindBillById(id);
        dataReturnRecord.setMessage("Get Bill By Id");
        dataReturnRecord.setData(bill_mapper.BillToBillDto(bill));
        return dataReturnRecord;

    }

    @GetMapping("/getbilllist/{accountName}")
    public DataReturnList<Bill_Dto> getBills(@PathVariable String accountName){
        DataReturnList<Bill_Dto> dataReturnList = new DataReturnList<>();

        try{
            dataReturnList.setMessage("Get All Invoice Of User");
            dataReturnList.setData(bill_service.findAllByUser(accountName).stream()
                    .map(bill_mapper::BillToBillDto).collect(Collectors.toList()));
        }catch (Exception e){
            dataReturnList.setMessage("Have No Invoice ???");
            dataReturnList.setSuccess("false");
        }

        return dataReturnList;
    }

    @GetMapping("/getproductincart/{accountname}")
    public DataReturnList<CartDetail_Dto> GetProductInCart(@PathVariable String accountname){
        Cart cart = user_service.FindByAccountName(accountname).getCart();
        DataReturnList<CartDetail_Dto> dataReturnList = new DataReturnList<>();
        dataReturnList.setData(cartDetail_service.RetrieveAllProductInCart(cart.getId())
                .stream()
                .map(cartDetail_mapper::CartDetailToCartDetailDto)
                .collect(Collectors.toList()));
        dataReturnList.setMessage("Get all product in cart");
        return dataReturnList;
    }

    @PostMapping("/addproductincart/{accountname}/{productid}/{quantity}/{size}")
    public DataReturnRecord<CartDetail_Dto> AddProductInCart (@PathVariable String accountname,
                                                              @PathVariable int productid, @PathVariable int quantity, @PathVariable String size){
        DataReturnRecord<CartDetail_Dto> dataReturnRecord = new DataReturnRecord<>();

        Cart cart = user_service.FindByAccountName(accountname).getCart();
        Product product = product_service.FindProductById(productid);

        Cart_Product_Id cart_product_id = new Cart_Product_Id();
        cart_product_id.setCart(cart);
        cart_product_id.setProduct(product);

        Cart_Detail cart_detail = new Cart_Detail();
        cart_detail.setId(cart_product_id);
        cart_detail.setQuantity(quantity);
        cart_detail.setSize(size);

        dataReturnRecord.setData(cartDetail_mapper.CartDetailToCartDetailDto(cartDetail_service.AddProductInCart(cart_detail)));
        dataReturnRecord.setMessage("Add products successful.");
        return dataReturnRecord;
    }

    @DeleteMapping("/deleteproductincart/{accountname}/{productid}")
    public DataReturnRecord<Product_Dto> DeleteProductInCart(@PathVariable String accountname, @PathVariable int productid){
        DataReturnRecord<Product_Dto> dataReturnRecord = new DataReturnRecord<>();

        Cart cart = user_service.FindByAccountName(accountname).getCart();
        Product product = product_service.FindProductById(productid);

        Cart_Product_Id cart_product_id = new Cart_Product_Id(cart,product);

        Cart_Detail cart_detail = new Cart_Detail();
        cart_detail.setId(cart_product_id);

        cartDetail_service.DeleteProductInCart(cart_detail);

        dataReturnRecord.setMessage("Delete Product Successfully.");
        dataReturnRecord.setData(product_mapper.ProductToProductDto(product));

        return dataReturnRecord;
    }

    @DeleteMapping("/deleteallproductincart/{accountname}")
    public boolean DeleteAllProductInCart(@PathVariable String accountname){
        Cart cart = user_service.FindByAccountName(accountname).getCart();
        return cartDetail_service.DeleteAllProductInCart(cart.getId());
    }

    @PostMapping("/payment/{accountname}")
    public boolean Payment (@PathVariable String accountname){
        User user = user_service.FindByAccountName(accountname);

        Date date = new Date();
        String address;

        Bill bill = new Bill();
        bill.setTotal(Double.valueOf(0));
        bill.setAddress(user.getAddress());
        bill.setPhone(user.getPhone());
        bill.setStatus(Integer.valueOf(0));
        bill.setDateCreate(date);
        bill.setDateUpdate(date);
        bill.setUserCreate(accountname);
        bill.setUserUpdate(accountname);
        bill.setUser(user);

        Bill addbill = bill_service.AddBill(bill);
        System.out.println(addbill.getId());
        Cart cart = user.getCart();
        List<Cart_Detail> cart_details = cartDetail_service.RetrieveAllProductInCart(cart.getId());

        List<Bill_Detail> bill_details = new ArrayList<>();

        for (Cart_Detail cart_detail: cart_details) {
            Bill_Product_Id bill_product_id = new Bill_Product_Id();
            bill_product_id.setBill(addbill);
            bill_product_id.setProduct(cart_detail.getId().getProduct());

            Bill_Detail bill_detail = new Bill_Detail();
            bill_detail.setId(bill_product_id);
            bill_detail.setPrice(cart_detail.getId().getProduct().getPrice());
            bill_detail.setQuantity(cart_detail.getQuantity());

            bill_details.add(billDetail_service.AddBillProduct(bill_detail));
        }

        return cartDetail_service.DeleteAllProductInCart(cart.getId());
    }
    @GetMapping("/types")
    public DataReturnList<Type_Dto> getAllType(){
        DataReturnList<Type_Dto> typeDtoDataReturnList = new DataReturnList<>();
        try{
            typeDtoDataReturnList.setMessage("Lay danh sach loai san pham thanh cong !!!");
            typeDtoDataReturnList.setData(type_service.findAllType().stream()
                    .map(type_mapper::TypeToTypeDto).collect(Collectors.toList()));
        }catch (Exception e){
            typeDtoDataReturnList.setSuccess("false");
            typeDtoDataReturnList.setMessage("Khong lay duoc danh sach loai san pham ???");
        }
        return typeDtoDataReturnList;
    }
    @GetMapping("/products")
    public DataReturnList<Product_Dto> getAllProductPaging(@RequestParam Optional<Integer> id ,@RequestParam Optional<String> keyword, @RequestParam Optional<Integer> page
            , @RequestParam Optional<Integer> size){
        DataReturnList<Product_Dto> dataReturnList = new DataReturnList<>();
        Page<Product> productPage = null;

        try {
            productPage = product_service.findAllProductPaging(id ,keyword, page, size);
            dataReturnList.setPagenumber(productPage.getTotalPages());
            dataReturnList.setData(productPage.getContent().stream().map(product_mapper::ProductToProductDto)
                    .collect(Collectors.toList()));
            dataReturnList.setMessage("Co " + dataReturnList.getPagenumber() + " trang san pham");
        }catch (Exception e){
            dataReturnList.setSuccess("false");
            dataReturnList.setMessage("Khong the lay san pham ???");
        }

        return dataReturnList;
    }
    @PostMapping("/thanhtoan/{total}")
    public boolean thanhToan(@RequestBody User userTemp, @PathVariable Double total){
        User user = user_service.FindByAccountName(userTemp.getAccountName());
        Date date = new Date();

        Bill bill = new Bill();
        bill.setTotal(total);
        bill.setUser(user);
        bill.setStatus(userTemp.getStatus());
        bill.setAddress(userTemp.getAddress());
        bill.setDateCreate(date);
        bill.setDateUpdate(date);
        bill.setUserCreate(userTemp.getAccountName());
        bill.setUserUpdate(userTemp.getAccountName());

        Bill billAdd = bill_service.AddBill(bill);

        System.out.println(billAdd.getId());

        Cart cart = user.getCart();
        List<Cart_Detail> cart_details = cartDetail_service.RetrieveAllProductInCart(cart.getId());

        List<Bill_Detail> bill_details = new ArrayList<>();

        for (Cart_Detail cart_detail: cart_details) {
            Bill_Product_Id bill_product_id = new Bill_Product_Id();
            bill_product_id.setBill(billAdd);
            bill_product_id.setProduct(cart_detail.getId().getProduct());
            Product product = product_service.FindProductById(cart_detail.getId().getProduct().getId());
            if(product.getQuantity()>=cart_detail.getQuantity()) {
                product.setQuantity(product.getQuantity() - cart_detail.getQuantity());
                product_service.editProduct(product);
            }
            Bill_Detail bill_detail = new Bill_Detail();
            bill_detail.setId(bill_product_id);
            bill_detail.setPrice(cart_detail.getId().getProduct().getPrice());
            bill_detail.setQuantity(cart_detail.getQuantity());

            bill_details.add(billDetail_service.AddBillProduct(bill_detail));
        }

        return cartDetail_service.DeleteAllProductInCart(cart.getId());
    }
    @PostMapping("/plusproductincart/{accountname}/{productid}/{quantity}/{size}")
    public DataReturnRecord<CartDetail_Dto> PlusProductInCart (@PathVariable String accountname,
                                                              @PathVariable int productid, @PathVariable int quantity, @PathVariable String size){
        DataReturnRecord<CartDetail_Dto> dataReturnRecord = new DataReturnRecord<>();

        Cart cart = user_service.FindByAccountName(accountname).getCart();
        Product product = product_service.FindProductById(productid);

        Cart_Product_Id cart_product_id = new Cart_Product_Id();
        cart_product_id.setCart(cart);
        cart_product_id.setProduct(product);

        Cart_Detail cart_detail = new Cart_Detail();
        cart_detail.setId(cart_product_id);
        if(product.getQuantity() >=quantity)
        {
            cart_detail.setQuantity(quantity+1);
        }
        else {
            cart_detail.setQuantity(quantity);
        }

        cart_detail.setSize(size);

        dataReturnRecord.setData(cartDetail_mapper.CartDetailToCartDetailDto(cartDetail_service.AddProductInCart(cart_detail)));
        dataReturnRecord.setMessage("Add products successful.");
        return dataReturnRecord;
    }
    @PostMapping("/minusproductincart/{accountname}/{productid}/{quantity}/{size}")
    public DataReturnRecord<CartDetail_Dto> MinusProductInCart (@PathVariable String accountname,
                                                               @PathVariable int productid, @PathVariable int quantity, @PathVariable String size){
        DataReturnRecord<CartDetail_Dto> dataReturnRecord = new DataReturnRecord<>();

        Cart cart = user_service.FindByAccountName(accountname).getCart();
        Product product = product_service.FindProductById(productid);

        Cart_Product_Id cart_product_id = new Cart_Product_Id();
        cart_product_id.setCart(cart);
        cart_product_id.setProduct(product);

        Cart_Detail cart_detail = new Cart_Detail();
        cart_detail.setId(cart_product_id);
        if(quantity == 1)
        {
            cart_detail.setQuantity(quantity);
        }
        else
        {
            cart_detail.setQuantity(quantity-1);
        }
        cart_detail.setSize(size);
        dataReturnRecord.setData(cartDetail_mapper.CartDetailToCartDetailDto(cartDetail_service.AddProductInCart(cart_detail)));
        dataReturnRecord.setMessage("Add products successful.");
        return dataReturnRecord;
    }

    @PostMapping("/plussizeincart/{accountname}/{productid}/{quantity}/{size}")
    public DataReturnRecord<CartDetail_Dto> PlusSizeInCart (@PathVariable String accountname,
                                                               @PathVariable int productid, @PathVariable int quantity, @PathVariable String size){
        DataReturnRecord<CartDetail_Dto> dataReturnRecord = new DataReturnRecord<>();

        Cart cart = user_service.FindByAccountName(accountname).getCart();
        Product product = product_service.FindProductById(productid);

        Cart_Product_Id cart_product_id = new Cart_Product_Id();
        cart_product_id.setCart(cart);
        cart_product_id.setProduct(product);
        int newSize = Integer.valueOf(size) + 1;

        Cart_Detail cart_detail = new Cart_Detail();
        cart_detail.setId(cart_product_id);
        cart_detail.setQuantity(quantity);
        cart_detail.setSize(String.valueOf(newSize));

        dataReturnRecord.setData(cartDetail_mapper.CartDetailToCartDetailDto(cartDetail_service.AddProductInCart(cart_detail)));
        dataReturnRecord.setMessage("Change size successful.");
        return dataReturnRecord;
    }

    @PostMapping("/minussizeincart/{accountname}/{productid}/{quantity}/{size}")
    public DataReturnRecord<CartDetail_Dto> MinusSizeInCart (@PathVariable String accountname,
                                                            @PathVariable int productid, @PathVariable int quantity, @PathVariable String size){
        DataReturnRecord<CartDetail_Dto> dataReturnRecord = new DataReturnRecord<>();

        Cart cart = user_service.FindByAccountName(accountname).getCart();
        Product product = product_service.FindProductById(productid);

        Cart_Product_Id cart_product_id = new Cart_Product_Id();
        cart_product_id.setCart(cart);
        cart_product_id.setProduct(product);
        int newSize = Integer.valueOf(size) - 1;

        Cart_Detail cart_detail = new Cart_Detail();
        cart_detail.setId(cart_product_id);
        cart_detail.setQuantity(quantity);
        cart_detail.setSize(String.valueOf(newSize));

        dataReturnRecord.setData(cartDetail_mapper.CartDetailToCartDetailDto(cartDetail_service.AddProductInCart(cart_detail)));
        dataReturnRecord.setMessage("Change size successful.");
        return dataReturnRecord;
    }
    @GetMapping("/wishlist/{userName}")
    public DataReturnList<Wishlist_Dto> getWishList(@PathVariable String userName){
        User user = user_service.FindByAccountName(userName);
        List<Wishlist> wishList = wishlist_repository.findAllByUserId(user.getId());
        List<Wishlist_Dto> wishListDTOS = new ArrayList<>();
        for (Wishlist item : wishList) {
            Wishlist_Dto wishItem = new Wishlist_Dto();
            wishItem.setProductName(item.getWishlist_id().getProduct().getName());
            wishItem.setUserId(item.getWishlist_id().getUser().getId());
            wishItem.setProductId(item.getWishlist_id().getProduct().getId());
            wishItem.setCurrentPrice(item.getWishlist_id().getProduct().getPrice());
            wishItem.setWishPrice(item.getDealPrice());
            wishItem.setImage(item.getWishlist_id().getProduct().getImages());
            wishItem.setQuantity(item.getWishlist_id().getProduct().getQuantity());
            wishListDTOS.add(wishItem);
        }

        DataReturnList<Wishlist_Dto> result = new DataReturnList<>();
        result.setData(wishListDTOS);
        result.setMessage("get wishlist successfully");
        return result;
    }
    @DeleteMapping("/deleteWishProduct/{userName}/{productId}")
    public DataReturnRecord<Wishlist_Dto> deleteWishProduct(@PathVariable String userName, @PathVariable Integer productId){
        DataReturnRecord<Wishlist_Dto> dataReturnRecord = new DataReturnRecord<>();

        Product product = product_service.FindProductById(productId);
        User user = user_service.FindByAccountName(userName);
        Wishlist_Id wishId = new Wishlist_Id();
        wishId.setUser(user);
        wishId.setProduct(product);

        wishlist_repository.deleteById(wishId);

        dataReturnRecord.setMessage("Delete Wish Item Successfully !!!");

        return dataReturnRecord;
    }
    @PostMapping("/addDealPrice/{userName}/{productId}/{dealPrice}")
    public DataReturnRecord<?> addDealPrice(@PathVariable String userName, @PathVariable Integer productId, @PathVariable Double dealPrice){

        DataReturnRecord<Cart_Detail> dataReturnRecord = new DataReturnRecord<>();

        User user = user_service.FindByAccountName(userName);
        Product product = product_service.FindProductById(productId);

        Wishlist_Id userProductId = new Wishlist_Id();
        userProductId.setUser(user);
        userProductId.setProduct(product);

        Wishlist userProduct = new Wishlist();
        userProduct.setWishlist_id(userProductId);
        userProduct.setDealPrice(dealPrice);

        wishlist_repository.save(userProduct);

        dataReturnRecord.setMessage("add deal price succesfully!");
        return dataReturnRecord;
    }


}
