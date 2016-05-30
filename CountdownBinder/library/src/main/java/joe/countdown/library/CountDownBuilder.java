package joe.countdown.library;

import java.util.HashMap;

/**
 * Description
 * Created by chenqiao on 2016/5/30.
 */
public class CountDownBuilder {

    private static HashMap<String, CountDownTimer> timers = new HashMap<>();

    public CountDownTimer create(String tag) {
        if (timers.containsKey(tag)) {
            return timers.get(tag);
        }
        CountDownTimer timer = new CountDownTimer(new CountDownData(tag));
        timers.put(tag, timer);
        return timer;
    }

    public CountDownTimer create(String tag, long allTime, long restTime, long interval) {
        if (timers.containsKey(tag)) {
            return timers.get(tag);
        }
        CountDownTimer timer = new CountDownTimer(new CountDownData(tag, allTime, restTime, interval));
        timers.put(tag, timer);
        return timer;
    }

    public CountDownTimer getCountDownByTag(String tag) {
        return timers.get(tag);
    }

    public static void removeByTag(String tag) {
        timers.remove(tag);
    }

    public static void clear() {
        for (CountDownTimer timer : timers.values()) {
            timer.cancel();
        }
        timers.clear();
    }
}
