package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by silence on 16/5/2.
 */
public abstract class AbstractHealthChecker implements Runnable {
    private CountDownLatch latch;
    private String serviceName;
    private boolean serviceUp;

    public AbstractHealthChecker(CountDownLatch latch, String serviceName) {
        super();
        this.latch = latch;
        this.serviceName = serviceName;
        this.serviceUp = false;
    }

    @Override
    public void run() {
        try {
            verifyService();
            serviceUp = true;
        } catch (Exception e) {
            e.printStackTrace();
            serviceUp = false;
        } finally {
            if (latch != null)
                latch.countDown();
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }

    public abstract void verifyService();
}
