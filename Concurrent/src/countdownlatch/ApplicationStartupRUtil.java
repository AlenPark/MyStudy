package countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by silence on 16/5/2.
 */
public class ApplicationStartupRUtil {
    private static final ApplicationStartupRUtil instance = new ApplicationStartupRUtil();
    private static List<AbstractHealthChecker> services;
    private static CountDownLatch latch;

    private ApplicationStartupRUtil() {
    }

    public static boolean checkExternalServices() throws InterruptedException {
        latch = new CountDownLatch(3);

        services = new ArrayList<AbstractHealthChecker>();
        services.add(new NetworkHealthChecker(latch, "network"));
        services.add(new DatabaseHealthChecker(latch, "database"));
        services.add(new CacheHealthChecker(latch, "cache"));

        ExecutorService service = Executors.newFixedThreadPool(services.size());
        for (AbstractHealthChecker checker : services) {
            service.execute(checker);
        }

        latch.await();

        for (AbstractHealthChecker checker : services) {
            if (!checker.isServiceUp())
                return false;
        }
        return true;
    }

    public ApplicationStartupRUtil getInstance() {
        return instance;
    }
}
