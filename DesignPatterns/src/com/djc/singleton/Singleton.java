package com.djc.singleton;

/**
 * 单例模式,懒汉式
 */
public class Singleton {
    /**
     * 私有化构造方法
     */
    private Singleton() {
    }

    /**
     * 外界获取单例的方法
     *
     * @return
     */
    public Singleton getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 类级内部类,只有被调用的时候才会被加载,实现了延迟加载
     */
    private static class SingletonHolder {
        /**
         * 静态初始化器,由JVM保证线程安全
         */
        private static Singleton instance = new Singleton();
    }
}
