package joe.countdown.library;

/**
 * Description
 * Created by chenqiao on 2016/5/30.
 */
public class CountDownData {

    private String tag;
    private long allTime;
    private long restTime;
    private boolean isFinished = false;
    private boolean isPaused = false;
    private long interval;
    private Object otherInfo;

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getAllTime() {
        return allTime;
    }

    public void setAllTime(long allTime) {
        this.allTime = allTime;
    }

    public long getRestTime() {
        return restTime;
    }

    public void setRestTime(long restTime) {
        this.restTime = restTime;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public Object getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(Object otherInfo) {
        this.otherInfo = otherInfo;
    }

    public CountDownData(String tag) {
        this.tag = tag;
    }

    public CountDownData(String tag, long allTime, long restTime, long interval) {
        this.tag = tag;
        this.allTime = allTime;
        this.restTime = restTime;
        this.interval = interval;
    }
}
