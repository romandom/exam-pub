package com.example.demo.resource;

import com.example.demo.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/summary")
public class SummaryResource {

    @Autowired
    SummaryService summaryService;

    @GetMapping("/all")
    public Map getSummary()
    {

        return summaryService.summaryAll();
    }

    @GetMapping("/product")
    public Map getAllProducts()
    {
        return summaryService.summaryProducts();

    }

    @GetMapping("/user")
    public Map getAllOrders()
    {

        return summaryService.summaryUsers();
    }

}
