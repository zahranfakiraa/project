package com.techmarket.project.services.customer.cart;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techmarket.project.dto.AddProductInCartDTO;
import com.techmarket.project.entity.Cartitems;
import com.techmarket.project.entity.Order;
import com.techmarket.project.entity.Product;
import com.techmarket.project.entity.User;
import com.techmarket.project.enums.OrderStatus;
import com.techmarket.project.repository.CartItemsRepository;
import com.techmarket.project.repository.OrderRepository;
import com.techmarket.project.repository.ProductRepository;
import com.techmarket.project.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemsRepository cartItemsRepository;

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<?> addProductToCart(AddProductInCartDTO addProductInCartDTO){
        Order activOrder = orderRepository.findByUserIdAndOrderStatus(addProductInCartDTO.getUserId(), OrderStatus.Pending);
        Optional<Cartitems> optionalCartItems = cartItemsRepository.findByProductIdAndOrderIdAndUserId
                (addProductInCartDTO.getProductId(), activOrder.getId(), addProductInCartDTO.getUserId());

        if(optionalCartItems.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        else{
            Optional<Product> optionalProduct = productRepository.findById(addProductInCartDTO.getProductId());
            Optional<User> optionalUser = userRepository.findById(addProductInCartDTO.getUserId());

            if(optionalProduct.isPresent() && optionalUser.isPresent()){
                Cartitems cart = new Cartitems();
                cart.setProduct(optionalProduct.get());
                cart.setPrice(optionalProduct.get().getPrice());
                cart.setQuantity(1L);
                cart.setUser(optionalUser.get());
                cart.setOrder(activOrder);

                Cartitems updatedCart = cartItemsRepository.save(cart);

                activOrder.setTotalAmount(activOrder.getTotalAmount() + cart.getPrice());
                activOrder.setAmount(activOrder.getAmount() + cart.getPrice());
                activOrder.getCartItems().add(cart);

                orderRepository.save(activOrder);

                return ResponseEntity.status(HttpStatus.CREATED).body(cart);
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or product not found");
            }
        }        
    }
}
