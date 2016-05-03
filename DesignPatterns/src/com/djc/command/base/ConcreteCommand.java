package com.djc.command.base;

/**
 * 具体的命令实现对象
 */
public class ConcreteCommand implements Command {
    /**
     * 持有相应的接受者对象
     */
    private Receiver receiver = null;

    /**
     * 命令对象可以有自己的状态
     */
    private String status;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void execute() {
        //通常调用接受者相应的方法来真正执行功能
        receiver.action();
    }
}
