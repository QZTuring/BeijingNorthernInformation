package com.bjni.controller;


import com.bjni.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping("/totalCost")
    public double getTotalCost(@RequestParam int appleWeight, @RequestParam int strawberryWeight) {
        return fruitService.AppleAndStrawberryCalculateTotalCost(appleWeight, strawberryWeight);
    }
}
