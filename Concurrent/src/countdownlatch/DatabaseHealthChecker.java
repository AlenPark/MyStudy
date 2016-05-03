package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by silence on 16/5/2.
 */
public class DatabaseHealthChecker extends AbstractHealthChecker {
    public DatabaseHealthChecker(CountDownLatch latch, String serviceName) {
        super(latch, serviceName);
    }

    @Override
    public void verifyService() {
        try {
            System.out.println("checking " + getServiceName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getServiceName() + " is up");
    }
}
