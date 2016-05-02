package com.djc.method;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        FruitFactory appleFactory = new AppleFactory();
        FruitFactory grapeFactory = new GrapeFactory();
        Fruit apple = appleFactory.getFruit();
        Fruit grape = grapeFactory.getFruit();
    }
}
