package com.djc.method;

/**
 * 苹果工厂
 */
public class AppleFactory implements FruitFactory {
    /**
     * 苹果工厂方法
     *
     * @return 苹果
     */
    public Fruit getFruit() {
        Fruit apple = new Apple();
        return apple;
    }
}
