package ddwucom.mobile.week05.practice02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    int x, y, r;
    int color;

    public int getCircleX() {
        return x;
    }

    public int getCircleY() {
        return y;
    }

    public int getCircleR() {
        return r;
    }

    public void setCircleX(int x) {
        this.x = x;
    }

    public void setCircleY(int y) {
        this.y = y;
    }

    public void setCircleR(int r) {
        this.r = r;
    }

    public MyView(Context context) {
        super(context);
        color = Color.CYAN;
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        color = Color.CYAN;
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        color = Color.CYAN;
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        color = Color.CYAN;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawCircle(x, y, r, paint);
    }
}
