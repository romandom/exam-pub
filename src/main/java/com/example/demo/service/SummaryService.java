package com.example.demo.service;


import com.example.demo.converter.SummaryAllConverter;
import com.example.demo.converter.SummaryProductConverter;
import com.example.demo.converter.SummaryUserConverter;
import com.example.demo.domain.dto.SummaryAllDto;
import com.example.demo.domain.dto.SummaryProductDto;
import com.example.demo.domain.dto.SummaryUserDto;
import com.example.demo.domain.repository.OrderRepositary;
import com.example.demo.domain.repository.ProductRepositary;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SummaryService {

    @Autowired
    private ProductRepositary productRepositary;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepositary orderRepository;

    public Map summaryAll(){

        Map<Integer, List<SummaryAllDto>> mapDrinks
                = new HashMap<Integer, List<SummaryAllDto>>();

        boolean keyExists;

        for(int i = 1; i <= orderRepository.findAll().size(); i++)
        {
            keyExists = false;
            for(Map.Entry<Integer, List<SummaryAllDto>> mapElement : mapDrinks.entrySet())
            {
                if(mapElement.getKey() == orderRepository.findById(i).get().getProduct().getId())
                {
                    keyExists = true;
                    mapElement.getValue().add(SummaryAllConverter.toDto(orderRepository.findById(i).get()));
                }
            }
            if(!keyExists)
            {
                List<SummaryAllDto> list = new ArrayList<SummaryAllDto>();
                list.add(SummaryAllConverter.toDto(orderRepository.findById(i).get()));
                mapDrinks.put(orderRepository.findById(i).get().getProduct().getId(), list);
            }
        }
        return mapDrinks;



    }

    public Map summaryUsers(){

        Map<Integer, List<SummaryUserDto>> mapDrinks
                = new HashMap<Integer, List<SummaryUserDto>>();

        boolean keyExists;

        for(int i = 1; i <= orderRepository.findAll().size(); i++)
        {
            keyExists = false;
            for(Map.Entry<Integer, List<SummaryUserDto>> mapElement : mapDrinks.entrySet())
            {
                if(mapElement.getKey() == orderRepository.findById(i).get().getUser().getId())
                {
                    keyExists = true;
                    mapElement.getValue().add(SummaryUserConverter.toDto(orderRepository.findById(i).get()));
                }
            }
            if(!keyExists)
            {
                List<SummaryUserDto> list = new ArrayList<SummaryUserDto>();
                list.add(SummaryUserConverter.toDto(orderRepository.findById(i).get()));
                mapDrinks.put(orderRepository.findById(i).get().getUser().getId(), list);
            }
        }
        return mapDrinks;
    }

    public Map summaryProducts(){

        Map<Integer, List<SummaryProductDto>> mapDrinks
                = new HashMap<Integer, List<SummaryProductDto>>();

        boolean keyExists;

        for(int i = 1; i <= orderRepository.findAll().size(); i++)
        {
            keyExists = false;
            for(Map.Entry<Integer, List<SummaryProductDto>> mapElement : mapDrinks.entrySet())
            {
                if(mapElement.getKey() == orderRepository.findById(i).get().getProduct().getId())
                {
                    keyExists = true;
                    mapElement.getValue().add(SummaryProductConverter.toDto(orderRepository.findById(i).get()));
                }
            }
            if(!keyExists)
            {
                List<SummaryProductDto> list = new ArrayList<SummaryProductDto>();
                list.add(SummaryProductConverter.toDto(orderRepository.findById(i).get()));
                mapDrinks.put(orderRepository.findById(i).get().getProduct().getId(), list);
            }
        }
        return mapDrinks;

    }

}
