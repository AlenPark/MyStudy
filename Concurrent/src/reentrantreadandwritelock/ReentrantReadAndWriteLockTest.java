package reentrantreadandwritelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/5/3.
 */
public class ReentrantReadAndWriteLockTest {
    public static void main(String[] args) {
        final Queue q = new Queue();
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 3; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    while (true)
                        q.get();
                }
            });
            service.execute(new Runnable() {
                @Override
                public void run() {
                    while (true)
                        q.put();
                }
            });
        }
    }
}
