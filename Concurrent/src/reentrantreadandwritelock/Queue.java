package reentrantreadandwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2016/5/3.
 */
public class Queue {
    private String data = "abc";

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void get() {
        lock.readLock().lock();

        System.out.println(Thread.currentThread().getName() + " be ready to read data!");

        System.out.println(Thread.currentThread().getName() + " have read data " + data);

        lock.readLock().unlock();
    }

    public void put() {
        lock.writeLock().lock();

        System.out.println(Thread.currentThread().getName() + " be ready to write data!");
        data = "xyz";

        System.out.println(Thread.currentThread().getName() + " have write data: " + data);

        lock.writeLock().unlock();
    }
}
