package com.bjni.service;


import com.bjni.model.Fruit;
import org.springframework.stereotype.Service;

@Service
public class FruitService {
    // 定义水果的价格
    private static final Fruit APPLE = new Fruit("Apple", 8.0);
    private static final Fruit STRAWBERRY = new Fruit("Strawberry", 13.0);
    private static final Fruit MANGO = new Fruit("Mango", 20.0);  // 新增芒果

    //计算苹果和草莓的总价
    public double AppleAndStrawberryCalculateTotalCost(int appleWeight, int strawberryWeight) {
        return (APPLE.getPricePerKg() * appleWeight) + (STRAWBERRY.getPricePerKg() * strawberryWeight);
    }

    //计算苹果和芒果的总价
    public double AppleAndMangoCalculateTotalCost(int appleWeight, int mangoWeight) {
        return (APPLE.getPricePerKg() * appleWeight) + (MANGO.getPricePerKg() * mangoWeight);
    }

    //计算草莓和芒果的总价
    public double StrawberryAndMangoCalculateTotalCost(int strawberryWeight, int mangoWeight) {
        return (STRAWBERRY.getPricePerKg() * strawberryWeight) + (MANGO.getPricePerKg() * mangoWeight);
    }

    //计算苹果、草莓、芒果的总价
    public double ThreeFruitsCalculateTotalCost(int mangoWeight, int appleWeight, int strawberryWeight) {
        return (APPLE.getPricePerKg() * appleWeight) + (STRAWBERRY.getPricePerKg() * strawberryWeight) + (MANGO.getPricePerKg() * mangoWeight);
    }

    //只购买芒果
    public double OnlyMangoCalculateTotalCost(int mangoWeight) {
        return (MANGO.getPricePerKg() * mangoWeight);
    }

    //只购买苹果
    public double OnlyAppleCalculateTotalCost(int appleWeight) {
        return (APPLE.getPricePerKg() * appleWeight);
    }

    //只购买草莓
    public double OnlyStrawberryCalculateTotalCost(int strawberryWeight) {
        return (STRAWBERRY.getPricePerKg() * strawberryWeight);
    }

    // 有促销活动计算总价的方法
    public double calculateTotalCost(int appleWeight, int strawberryWeight, int mangoWeight, boolean isStrawberryDiscount) {
        double strawberryPricePerKg = STRAWBERRY.getPricePerKg();

        // 如果有促销活动，草莓打 8 折
        if (isStrawberryDiscount) {
            strawberryPricePerKg *= 0.8;
        }

        return (APPLE.getPricePerKg() * appleWeight) +
                (strawberryPricePerKg * strawberryWeight) +
                (MANGO.getPricePerKg() * mangoWeight);
    }


    // 计算打折后再进行满减优惠总价的方法
    public double calculateDiscountedTotalCost(int appleWeight, int strawberryWeight, int mangoWeight, boolean isStrawberryDiscount) {
        double strawberryPricePerKg = STRAWBERRY.getPricePerKg();

        // 如果有促销活动，草莓打 8 折
        if (isStrawberryDiscount) {
            strawberryPricePerKg *= 0.8;
        }

        // 计算原始总价
        double totalCost = (APPLE.getPricePerKg() * appleWeight) +
                (strawberryPricePerKg * strawberryWeight) +
                (MANGO.getPricePerKg() * mangoWeight);

        // 满减优惠，满 100 减 10
        if (totalCost >= 100) {
            totalCost -= 10;
        }

        return totalCost;
    }

}
