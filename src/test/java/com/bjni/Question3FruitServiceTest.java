package com.bjni;


import com.bjni.service.FruitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Question3FruitServiceTest {

    @Autowired
    private FruitService fruitService;

    @Test
    public void testCalculateTotalCostWithDiscountedStrawberries() {
        // 测试场景: 购买若干斤苹果、草莓和芒果，且草莓打 8 折
        int appleWeight = 2;
        int strawberryWeight = 5;
        int mangoWeight = 3;

        double expectedTotalCost = (appleWeight * 8.0) + (strawberryWeight * 13.0 * 0.8) + (mangoWeight * 20.0);
        double actualTotalCost = fruitService.calculateTotalCost(appleWeight, strawberryWeight, mangoWeight, true);

        assertEquals(expectedTotalCost, actualTotalCost, 0.01);
    }

    @Test
    public void testCalculateTotalCostWithoutDiscount() {
        // 测试场景: 不打折的情况下购买若干斤苹果、草莓和芒果
        int appleWeight = 2;
        int strawberryWeight = 5;
        int mangoWeight = 3;

        double expectedTotalCost = (appleWeight * 8.0) + (strawberryWeight * 13.0) + (mangoWeight * 20.0);
        double actualTotalCost = fruitService.calculateTotalCost(appleWeight, strawberryWeight, mangoWeight, false);

        assertEquals(expectedTotalCost, actualTotalCost, 0.01);
    }
}
