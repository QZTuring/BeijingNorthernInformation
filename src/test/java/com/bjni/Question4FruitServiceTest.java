package com.bjni;


import com.bjni.service.FruitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Question4FruitServiceTest {

    @Autowired
    private FruitService fruitService;

    @Test
    public void testCalculateTotalCostWithDiscountedStrawberriesAndFullReduction() {
        // 测试场景: 购买若干斤苹果、草莓和芒果，草莓打 8 折，且满 100 减 10
        int appleWeight = 4;
        int strawberryWeight = 5;
        int mangoWeight = 3;

        double expectedTotalCost = (appleWeight * 8.0) + (strawberryWeight * 13.0 * 0.8) + (mangoWeight * 20.0);
        if (expectedTotalCost >= 100) {
            expectedTotalCost -= 10;
        }

        double actualTotalCost = fruitService.calculateTotalCost(appleWeight, strawberryWeight, mangoWeight, true);

        assertEquals(expectedTotalCost, actualTotalCost, 0.01);
    }

    @Test
    public void testCalculateTotalCostWithoutDiscountButWithFullReduction() {
        // 测试场景: 不打折的情况下购物，且总价满 100 减 10
        int appleWeight = 5;
        int strawberryWeight = 4;
        int mangoWeight = 2;

        double expectedTotalCost = (appleWeight * 8.0) + (strawberryWeight * 13.0) + (mangoWeight * 20.0);
        if (expectedTotalCost >= 100) {
            expectedTotalCost -= 10;
        }

        double actualTotalCost = fruitService.calculateTotalCost(appleWeight, strawberryWeight, mangoWeight, false);

        assertEquals(expectedTotalCost, actualTotalCost, 0.01);
    }

    @Test
    public void testCalculateTotalCostWithoutFullReduction() {
        // 测试场景: 购物总价未达到 100，不享受满减优惠
        int appleWeight = 2;
        int strawberryWeight = 1;
        int mangoWeight = 1;

        double expectedTotalCost = (appleWeight * 8.0) + (strawberryWeight * 13.0) + (mangoWeight * 20.0);

        double actualTotalCost = fruitService.calculateTotalCost(appleWeight, strawberryWeight, mangoWeight, false);

        assertEquals(expectedTotalCost, actualTotalCost, 0.01);
    }
}
