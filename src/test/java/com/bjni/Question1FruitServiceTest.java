package com.bjni;

import com.bjni.service.FruitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Configuration
public class Question1FruitServiceTest {

    @Autowired
    private FruitService fruitService;

    //        // 使用 Scanner 允许用户输入
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("请输入苹果的斤数: ");
//        int appleWeight = scanner.nextInt();
//
//        System.out.print("请输入草莓的斤数: ");
//        int strawberryWeight = scanner.nextInt();

    int appleWeight = 0;
    int strawberryWeight = 0;
    double expectedTotalCost = 0.0;

    @Test
    public void testCalculateTotalCostWithNoFruits() {
        // 情况 1: 不购买任何水果
        try {
            double actualTotalCost = fruitService.AppleAndStrawberryCalculateTotalCost(0, 0); // 直接使用0代替变量，避免冗余
            //assertEquals方法是比较两个浮点数是否相等，第二个参数（delta/0.01）是允许的误差范围
            assertEquals(expectedTotalCost, actualTotalCost, 0.01);
        } catch (IllegalArgumentException e) {
            // 处理计算中可能出现的非法参数异常
            System.err.println("计算水果总价时发生错误: " + e.getMessage());
        }

        System.out.println("不购买任何水果测试通过");
    }



    @Test
    public void testCalculateTotalCostWithOnlyApples() {
        // 情况 2: 只购买苹果
        appleWeight = 5;
        strawberryWeight = 0;
        expectedTotalCost = 5 * 8.0;

        assertEquals(expectedTotalCost, fruitService.AppleAndStrawberryCalculateTotalCost(appleWeight, strawberryWeight), 0.01);
        System.out.println("只购买苹果测试通过");

    }

    @Test
    public void testCalculateTotalCostWithOnlyStrawberries() {
        // 情况 3: 只购买草莓
        appleWeight = 0;
        strawberryWeight = 4;
        expectedTotalCost = 4 * 13.0;

        assertEquals(expectedTotalCost, fruitService.AppleAndStrawberryCalculateTotalCost(appleWeight, strawberryWeight), 0.01);

        System.out.println("只购买草莓测试通过");
    }

    @Test
    public void testCalculateTotalCostWithBothFruits() {
        // 情况 4: 购买苹果和草莓
        appleWeight = 3;
        strawberryWeight = 6;
        expectedTotalCost = (3 * 8.0) + (6 * 13.0);

        assertEquals(expectedTotalCost, fruitService.AppleAndStrawberryCalculateTotalCost(appleWeight, strawberryWeight), 0.01);
        System.out.println("购买苹果和草莓测试通过");
    }

    @Test
    public void testCalculateTotalCostWithLargeQuantities() {
        // 情况 5: 购买大量苹果和草莓
        appleWeight = 100;
        strawberryWeight = 200;

        try {
            expectedTotalCost = (appleWeight * 8.0) + (strawberryWeight * 13.0);
            double actualTotalCost = fruitService.AppleAndStrawberryCalculateTotalCost(appleWeight, strawberryWeight);

            //assertEquals方法是比较两个浮点数是否相等，第二个参数（delta/0.01）是允许的误差范围
            assertEquals(expectedTotalCost, actualTotalCost, 0.01);
            System.out.println("测试通过: 预期值 = " + expectedTotalCost + ", 实际值 = " + actualTotalCost);
            System.out.println("购买大量苹果和草莓测试通过");

        } catch (IllegalArgumentException e) {
            System.err.println("计算水果总价时发生错误: " + e.getMessage());
        }
    }






}
