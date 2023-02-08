package techproed.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class ListenersRetry implements IRetryAnalyzer {
    // bu sinif sadece kalan testleri tekrar calistirir. kac defa calistirmak istedigimizi  maxretycount da yazabiliriz.
    private int retryCount = 0;
    private static final int maxRetryCount = 2;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}