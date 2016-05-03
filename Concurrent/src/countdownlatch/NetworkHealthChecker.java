package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by silence on 16/5/2.
 */
public class NetworkHealthChecker extends AbstractHealthChecker {
    public NetworkHealthChecker(CountDownLatch latch, String serviceName) {
        super(latch, serviceName);
    }

    @Override
    public void verifyService() {
        try {
            System.out.println("checking " + getServiceName());
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getServiceName() + " is up");
    }
}
