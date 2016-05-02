package com.djc.method;

/**
 * 水果工厂接口
 */
public interface FruitFactory {
    /**
     * 工厂方法
     *
     * @return 生产出来的水果
     */
    Fruit getFruit();
}
