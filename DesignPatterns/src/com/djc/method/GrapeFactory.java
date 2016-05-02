package com.djc.method;

/**
 * 葡萄工厂
 */
public class GrapeFactory implements FruitFactory {
    /**
     * 工厂方法
     *
     * @return 葡萄
     */
    public Fruit getFruit() {
        Fruit grape = new Grape();
        return grape;
    }
}
