package ddwucom.mobile.week04.LayoutTest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.
//        setContentView(R.layout.activity_main);
//
        //2. set어쩌구는 inflation기능을 내장하고있음
//        LinearLayout linear = new LinearLayout(this);
//        linear.setOrientation(LinearLayout.VERTICAL);
//        linear.setBackgroundColor(Color.LTGRAY);
//
//        TextView text = new TextView(this);
//        text.setText("TextView");
//        text.setGravity(Gravity.CENTER);
//        text.setTextColor(Color.RED);
//        text.setTextSize(20);
//
//        linear.addView(text);
//        setContentView(linear ,LinearLayout.LayoutParams);

        //3. setContentView(R.layout.activity_main);와 같은작업
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);//시스템한테 요청하는 메소드
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.activity_main,null);

        setContentView(layout); //인플레이션해서 화면객체만드는작업을 내가 해줌
    }

    public void onClick (View v) {
        LinearLayout layout = findViewById(R.id.layout);
        switch(layout.getOrientation()) {
            case LinearLayout.HORIZONTAL:
                layout.setOrientation(LinearLayout.VERTICAL);
                break;
            case LinearLayout.VERTICAL:
                layout.setOrientation(LinearLayout.HORIZONTAL);
                break;
        }
    }
}