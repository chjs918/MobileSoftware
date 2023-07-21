package ddwucom.mobile.week05.myviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MyView myView = new MyView(this);
//        setContentView(myView);
    }

    public void onClick(View v) {
        MyCustomView myCustomView = findViewById(R.id.myCustomView);
        myCustomView.setColor(Color.YELLOW);
        myCustomView.invalidate();
    }

//    class MyView extends View {
//        public MyView(Context context) {
//            super(context);
//        }
//
//        @Override
//        protected void onDraw(Canvas canvas) {
//            canvas.drawColor(Color.LTGRAY);
//            Paint paint = new Paint(); //변수이름은 소문자로
//            paint.setColor(Color.BLUE); //그림을 그리는 도구에 색설정
//            canvas.drawCircle(100,100,80,paint);
//        }
//    }
}