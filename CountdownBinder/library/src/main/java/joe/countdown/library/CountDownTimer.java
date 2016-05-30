package joe.countdown.library;

/**
 * Description
 * Created by chenqiao on 2016/5/30.
 */
public class CountDownTimer {
    private CountDownData data;
    private TickDraw view;
    private android.os.CountDownTimer timer;
    private CountDownListener listener;

    public CountDownTimer(String tag) {
        this.data = new CountDownData(tag);
    }

    public CountDownTimer(CountDownData data) {
        this.data = data;
    }

    public CountDownData getData() {
        return data;
    }

    public void setData(CountDownData data) {
        this.data = data;
    }

    public void setTickView(TickDraw view) {
        this.view = view;
    }

    private void setCountDown(long allTime, long interval) {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        data.setRestTime(allTime);
        timer = new android.os.CountDownTimer(allTime, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                data.setRestTime(millisUntilFinished);
                if (view != null) {
                    view.onTick(data.getAllTime(), data.getRestTime());
                }
                if (listener != null) {
                    listener.onTick(millisUntilFinished);
                }
            }

            @Override
            public void onFinish() {
                if (view != null) {
                    view.onFinish();
                }
                if (listener != null) {
                    listener.onFinish();
                }
                data.setFinished(true);
                CountDownBuilder.removeByTag(data.getTag());
            }
        };
    }

    public void setTime(long allTime, long restTime, long interval) {
        data.setAllTime(allTime);
        data.setRestTime(restTime);
        data.setInterval(interval);
    }

    public void start() {
        setCountDown(data.getRestTime(), data.getInterval());
        data.setFinished(false);
        data.setPaused(false);
        timer.start();
    }

    public void pause() {
        if (timer != null) {
            timer.cancel();
            data.setPaused(true);
        }
    }

    public void resume() {
        if (timer != null && data.isPaused()) {
            start();
        }
    }

    public void cancel() {
        if (timer != null) {
            timer.cancel();
        }
        data.setRestTime(data.getAllTime());
        CountDownBuilder.removeByTag(data.getTag());
    }

    public boolean isPaused() {
        return data.isPaused();
    }

    public boolean isOver() {
        return data.isFinished();
    }

    public void setOnCountDownListener(CountDownListener listener) {
        this.listener = listener;
    }

    public interface CountDownListener {
        void onTick(long millsUnitFinish);

        void onFinish();
    }
}
