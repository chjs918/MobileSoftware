package ddwucom.mobile.test06.exam02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyView myView;
    float circleX, circleY;
    int paintColor;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = (MyView) findViewById(R.id.myView);

        //2.
        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                circleX = event.getX();
                circleY = event.getY();

                myView.setPosX(circleX);
                myView.setPosY(circleY);

                myView.invalidate();

                return false;
            }
        });

        //3.
        myView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                paintColor = Color.BLUE;
                myView.setPaintColor(paintColor);

                myView.invalidate();

                return true;
            }
        });
    }
}
