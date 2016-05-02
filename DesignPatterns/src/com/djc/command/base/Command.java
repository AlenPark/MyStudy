package com.djc.command.base;

/**
 * 命令接口,声明执行的操作
 */
public interface Command {
    /**
     * 执行命令的对应操作
     */
    public void execute();
}
