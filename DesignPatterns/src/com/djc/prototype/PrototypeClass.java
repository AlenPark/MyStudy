package com.djc.prototype;

/**
 * 原型模式
 */
public class PrototypeClass implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
