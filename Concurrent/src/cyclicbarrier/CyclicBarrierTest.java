package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/5/3.
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        //final CyclicBarrier barrier = new CyclicBarrier(3);
        final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("准备，出发!");
            }
        });

        for (int i = 0; i < 3; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) Math.random() * 100000);
                        System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合点1，已经有" + barrier.getNumberWaiting() + "个线程已经在等候");
                        barrier.await();

                        Thread.sleep((long) Math.random() * 100000);
                        System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合点2，已经有" + barrier.getNumberWaiting() + "个线程已经在等候");
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
