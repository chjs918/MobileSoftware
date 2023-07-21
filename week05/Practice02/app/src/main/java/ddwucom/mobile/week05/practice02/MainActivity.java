package ddwucom.mobile.week05.practice02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = findViewById(R.id.MyView);
    }

    public void onClick(View v){
        Random random = new Random();
        int x, y, r;

        x = random.nextInt(500);
        y = random.nextInt(800);
        r = (random.nextInt(3)+1) * 100;

        switch (v.getId()){
            case R.id.button:
                myView.setCircleX(x);
                myView.setCircleY(y);
                myView.setCircleR(r);
                myView.invalidate();
                break;
        }
    }
}