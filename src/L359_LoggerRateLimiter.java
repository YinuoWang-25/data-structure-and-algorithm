import java.util.HashMap;
import java.util.Map;
// 359. Logger Rate Limiter

public class L359_LoggerRateLimiter {
    Map<String, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public L359_LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        } else return false;
    }
}
