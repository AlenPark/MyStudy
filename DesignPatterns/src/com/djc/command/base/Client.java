package com.djc.command.base;

/**
 * 客户端
 */
public class Client {

    public static void main(String[] args) {
        //创建接受者对象
        Receiver receiver = new Receiver();
        //创建命令对象并设置它的接受者
        Command command = new ConcreteCommand(receiver);
        //创建调用者对象
        Invoker invoker = new Invoker();
        //设置命令对象
        invoker.setCommand(command);
        //调用命令执行
        invoker.runCommand();
    }

}
