package com.example.demo.service;

import com.example.demo.domain.dto.BuyDto;
import com.example.demo.domain.entity.OrderEntity;
import com.example.demo.domain.entity.ProductEntity;
import com.example.demo.domain.entity.UserEntity;
import com.example.demo.domain.repository.ProductRepositary;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class BuyService {

    @Autowired
    private ProductRepositary productRepositary;

    @Autowired
    private UserRepository userRepository;

    public String buy(BuyDto buyDto)
    {

        Optional<ProductEntity> productEntityOptional = productRepositary.findById(buyDto.getProductId());

        Optional<UserEntity> userEntityOptional = userRepository.findById(buyDto.getUserId());

        if (productEntityOptional.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product entity is empty");
        }

        ProductEntity product = productEntityOptional.get();

        if (userEntityOptional.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User entity is empty");
        }

        UserEntity user = userEntityOptional.get();

        OrderEntity order = new OrderEntity();

        if(productEntityOptional.get().isForAdult)
        {
            if(!userEntityOptional.get().isAdult)
            {
                return "Osoba je nepolnoleta";
            }else
            {
                if(productEntityOptional.get().price <= buyDto.getPrice())
                {
                    order.setProduct(product);
                    order.setUser(user);
                    order.setAmount(1);
                    order.setUnitPrice(product.price);
                    order.setTotalPrice(1 * product.getPrice());

                    user.getOrders().add(order);

                    userRepository.save(user);

                    return "Osoba je plnoleta a ma dost penazi";
                }else
                {
                    return "Osoba je plnoleta a nema dost penazi";
                }
            }
        }else
        {
            if(productEntityOptional.get().price <= buyDto.getPrice())
            {
                order.setProduct(product);
                order.setUser(user);
                order.setAmount(1);
                order.setUnitPrice(product.price);
                order.setTotalPrice(1 * product.getPrice());

                user.getOrders().add(order);

                userRepository.save(user);
                return "Osoba ma dost penazi";
            }else
            {
                return "Osoba nema dost penazi";
            }
        }

    }

}
