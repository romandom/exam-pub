package com.example.demo.resource;

import com.example.demo.domain.dto.BuyDto;
import com.example.demo.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy")
public class BuyResource {

    @Autowired
    BuyService buyService;

    @PostMapping()
    @ResponseStatus (HttpStatus.CREATED)
    public String
        createBuy(@RequestBody BuyDto buyDto) {
        {
            return buyService.buy(buyDto);
        }
    }
}
