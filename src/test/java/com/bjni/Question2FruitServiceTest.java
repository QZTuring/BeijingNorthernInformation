package com.bjni;


import com.bjni.service.FruitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Question2FruitServiceTest {

    @Autowired
    private FruitService fruitService;

    // 测试场景 1: 购买若干斤苹果、草莓和芒果
    @Test
    public void testBuyThreeFruits() {
        int appleCount = 10;
        int bananaCount = 5;
        int mangoCount = 3;
        int totalCount = appleCount + bananaCount + mangoCount;
        double totalPrice = fruitService.ThreeFruitsCalculateTotalCost(appleCount, bananaCount, mangoCount);
        assertEquals(totalCount * 1.5, totalPrice);

    }

    // 测试场景 2: 只购买芒果
    @Test
    public void testBuyMango() {
        int mangoCount = 3;
        double totalPrice = fruitService.OnlyMangoCalculateTotalCost(mangoCount);
        assertEquals(mangoCount * 2.5, totalPrice);
    }

    @Test
    public void testCalculateTotalCostWithZeroQuantities() {
        // 测试场景 3: 不购买任何水果
        int appleWeight = 0;
        int strawberryWeight = 0;
        int mangoWeight = 0;

        double expectedTotalCost = 0.0;
        double actualTotalCost = fruitService.ThreeFruitsCalculateTotalCost(appleWeight, strawberryWeight, mangoWeight);

        assertEquals(expectedTotalCost, actualTotalCost, 0.01);
    }

}
