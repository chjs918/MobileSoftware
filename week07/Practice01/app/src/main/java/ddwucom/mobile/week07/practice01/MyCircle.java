package ddwucom.mobile.week07.practice01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCircle extends View {

    private int x, y, r = 80;
    private Paint myPaint;
    private int color = Color.RED;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public MyCircle(Context context) {
        super(context);
        myPaint = new Paint();
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        myPaint = new Paint();
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        myPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        myPaint.setColor(getColor());

        //canvas의 가로길이, 세로길이의 반
        x=getWidth()/2;
        y=getHeight()/2;

        canvas.drawCircle(x,y,r,myPaint);
    }
}