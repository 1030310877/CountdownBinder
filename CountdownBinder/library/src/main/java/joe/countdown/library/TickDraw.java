package joe.countdown.library;

/**
 * Description
 * Created by chenqiao on 2016/5/30.
 */
public interface TickDraw {
    void onTick(long allTime, long restTime);

    void onFinish();
}
