package exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/5/3.
 */
public class ExchangerTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        final Exchanger exchanger = new Exchanger();

        service.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "abc";
                System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 + "换出去");
                try {
                    String data2 = (String) exchanger.exchange(data1);
                    System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        service.execute(new Runnable() {
            @Override
            public void run() {
                String data1 = "xyz";
                System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 + "换出去");
                try {
                    String data2 = (String) exchanger.exchange(data1);
                    System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.shutdown();
    }
}
