package com.djc.factory.simple;

/**
 * 工厂类,用来创建Api对象
 */
public class Factory {
    /**
     * 具体创建Api对象的方法
     *
     * @param condition 从外部传入的条件
     * @return 创建好的Api对象
     */
    public static Api createApi(int condition) {
        Api api = null;
        if (condition == 1)
            api = new ImplA();
        else if (condition == 2)
            api = new ImplB();

        return api;
    }
}
