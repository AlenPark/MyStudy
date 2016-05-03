package countdownlatch;

/**
 * Created by silence on 16/5/2.
 */
public class Test {
    public static void main(String[] args) {
        boolean isSucc = false;
        try {
            isSucc = ApplicationStartupRUtil.checkExternalServices();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("External services vallidation completed.Result is " + isSucc);
    }
}
