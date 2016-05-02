package com.djc.method;

/**
 * 水果工厂的产品:葡萄
 */
public class Grape implements Fruit {
    private boolean seedless;

    public void plant() {

    }

    public void grow() {

    }

    public void harvest() {

    }

    public boolean isSeedless() {
        return seedless;
    }

    public void setSeedless(boolean seedless) {
        this.seedless = seedless;
    }
}
