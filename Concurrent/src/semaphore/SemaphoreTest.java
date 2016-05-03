package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Administrator on 2016/5/3.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        //创建信号量并初始化大小
        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "进入，当前已有" + (3 - semaphore.availablePermits()) + "个并发");
                        Thread.sleep((long) Math.random() * 100000);
                        System.out.println("线程" + Thread.currentThread().getName() +
                                "即将离开");
                        semaphore.release();
                        System.out.println("线程" + Thread.currentThread().getName() + "已离开");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
