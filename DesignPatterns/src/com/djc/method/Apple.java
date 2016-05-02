package com.djc.method;

/**
 * 水果工厂的产品:苹果
 */
public class Apple implements Fruit {
    /**
     * 树的年龄
     */
    private int treeAge;

    public void plant() {

    }

    public void grow() {

    }

    public void harvest() {

    }

    public int getTreeAge() {
        return treeAge;
    }

    public void setTreeAge(int treeAge) {
        this.treeAge = treeAge;
    }
}
