package joe.countdown.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import joe.countdown.library.TickDraw;

/**
 * Description
 * Created by chenqiao on 2016/5/30.
 */
public class TimeTextView extends TextView implements TickDraw {
    public TimeTextView(Context context) {
        super(context);
    }

    public TimeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TimeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onTick(long allTime, long restTime) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        Date date = new Date(restTime);
        String text = format.format(date);
        setText(text);
    }

    @Override
    public void onFinish() {
        setText("Finished");
    }
}
