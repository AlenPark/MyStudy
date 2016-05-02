package com.djc.command.base;

/**
 * 调用者对象
 */
public class Invoker {
    /**
     * 持有命令对象
     */
    private Command command = null;

    /**
     * 设置调用者持有的命令对象
     *
     * @param command 命令对象
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 要求命令执行
     */
    public void runCommand() {
        command.execute();
    }
}
