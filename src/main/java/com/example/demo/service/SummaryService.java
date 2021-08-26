package com.example.demo.service;


import com.example.demo.converter.SummaryAllConverter;
import com.example.demo.converter.SummaryProductConverter;
import com.example.demo.converter.SummaryUserConverter;
import com.example.demo.domain.dto.SummaryAllDto;
import com.example.demo.domain.dto.SummaryProductDto;
import com.example.demo.domain.dto.SummaryUserDto;
import com.example.demo.domain.entity.OrderEntity;
import com.example.demo.domain.repository.OrderRepositary;
import com.example.demo.domain.repository.ProductRepositary;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SummaryService {

    @Autowired
    private OrderRepositary orderRepository;

    private boolean keyExists;

    public Map summaryAll(){

        Map<Integer, List<SummaryAllDto>> mapDrinks
                = new HashMap<Integer, List<SummaryAllDto>>();

        List<OrderEntity> orders = orderRepository.findAll();

        int countOfSameProducts;

        for(OrderEntity i : orders)
        {
            countOfSameProducts = 1;
            for(int j = i.getId()-1; j < orders.size(); j++)
            {
                if(i.getId() != orders.get(j).getId() && i.getProduct().getId() == orders.get(j).getProduct().getId() && i.getUser().getId() == orders.get(j).getUser().getId())
                {
                    countOfSameProducts ++;
                    orders.get(j).setUnitPrice(0);
                }
            }
            i.setAmount(countOfSameProducts);
            i.setTotalPrice(countOfSameProducts*i.getUnitPrice());
        }

        for(OrderEntity i : orders)
        {
            keyExists = false;
            for(Map.Entry<Integer, List<SummaryAllDto>> mapElement : mapDrinks.entrySet())
            {
                if(mapElement.getKey() == i.getUser().getId() && i.getUnitPrice() != 0)
                {
                    keyExists = true;
                    mapElement.getValue().add(SummaryAllConverter.toDto(i));
                }
            }
            if(!keyExists && i.getUnitPrice() != 0)
            {
                List<SummaryAllDto> list = new ArrayList<SummaryAllDto>();
                list.add(SummaryAllConverter.toDto(i));
                mapDrinks.put(i.getProduct().getId(), list);
            }
        }
        return mapDrinks;



    }

    public Map summaryUsers(){

        Map<Integer, List<SummaryUserDto>> mapDrinks
                = new HashMap<Integer, List<SummaryUserDto>>();

        List<OrderEntity> orders = orderRepository.findAll();

        for(OrderEntity i : orders)
        {
            keyExists = false;
            for(Map.Entry<Integer, List<SummaryUserDto>> mapElement : mapDrinks.entrySet())
            {
                if(mapElement.getKey() == i.getUser().getId())
                {
                    keyExists = true;
                    mapElement.getValue().add(SummaryUserConverter.toDto(i));
                }
            }
            if(!keyExists)
            {
                List<SummaryUserDto> list = new ArrayList<SummaryUserDto>();
                list.add(SummaryUserConverter.toDto(i));
                mapDrinks.put(i.getUser().getId(), list);
            }
        }
        return mapDrinks;
    }

    public Map summaryProducts(){

        Map<Integer, List<SummaryProductDto>> mapDrinks
                = new HashMap<Integer, List<SummaryProductDto>>();

        List<OrderEntity> orders = orderRepository.findAll();

        for(OrderEntity i : orders)
        {
            keyExists = false;
            for(Map.Entry<Integer, List<SummaryProductDto>> mapElement : mapDrinks.entrySet())
            {
                if(mapElement.getKey() == i.getProduct().getId())
                {
                    keyExists = true;
                    mapElement.getValue().add(SummaryProductConverter.toDto(i));
                }
            }
            if(!keyExists)
            {
                List<SummaryProductDto> list = new ArrayList<SummaryProductDto>();
                list.add(SummaryProductConverter.toDto(i));
                mapDrinks.put(i.getProduct().getId(), list);
            }
        }
        return mapDrinks;

    }

}
