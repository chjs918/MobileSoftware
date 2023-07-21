package ddwucom.mobile.week05.myviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCustomView extends View {

    int color;

    public MyCustomView(Context context) {
        super(context);
        color = Color.RED;
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        color = Color.RED;
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        color = Color.RED;
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public int getColor(){
        return color;
    }

    public void setColor(int color){
        this.color = color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.LTGRAY);
        Paint paint = new Paint(); //변수이름은 소문자로
        paint.setColor(color); //그림을 그리는 도구에 색설정
        canvas.drawCircle(100,100,80,paint);
        canvas.drawCircle(200,200,100, paint);
        canvas.drawRect(300,300,500,500,paint);
    }
}
