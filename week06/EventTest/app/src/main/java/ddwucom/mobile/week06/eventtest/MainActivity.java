package ddwucom.mobile.week06.eventtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                textView.setText("Moblie Software");
                return true;
            }
        });
        //oncreate실행되고 textview찾고 끝나는순간 textview는 지역변수라서 존재하지않는다
        //실행되지마자 실행됐다 사라져버림(실행안됨)
        //1. textview변수 멤버변수로 만들어서 유지해줌
        //2. final textview로 상수값 저장
        //onCreate안에서 생성하면 사용할수 있게 바뀜 안드스가 유해져서
        Button button = findViewById(R.id.button);
        MyClick myClick = new MyClick();
        //OnClickListener를 구현한 클래스로 객체를 만들었다.
        // button.setOnClickListener(myInterfaceClick);
        //setOnClickListener로 버튼과 객체를 연결한다.

        //변수가 직접 들어가면 변수이름 정의할필요가 없다(간단한 코드일때)
        //2.5 임시 객체 (다른데서 쓸수 없음! 이름이없어,,)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click!!!", Toast.LENGTH_SHORT).show();
            }
        });
        // button.setOnClickListener(this); //메인 액티비티클래스가 하니까 this
    }

    //메인액티비티가 직접구현- 권장하지 않는다 (복잡해질수있어서)
//    @Override
//    public void onClick(View view) {
//        Toast.makeText(MainActivity.this, "Click!!!", Toast.LENGTH_SHORT);
//    }

    class MyClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Click!!!", Toast.LENGTH_SHORT).show();
        }//그냥 this쓰면 myClick을 가리키는것, 정확하게 써준다
    }

    //담는변수 만들어서 직접연결- 쉬운방법! (방법 2.4)
    //원래는 x, new 해서 만드는순간 onClick 메소드를 바로 채워버리면 가능
    //레퍼런스 변수 = 객체를 가리키고 있는 변수
    View.OnClickListener myInterfaceClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Click!!!", Toast.LENGTH_SHORT).show();
        }
    }; //원래이부분이 생략돼야하는데 동시에 해줘야해서 생략 x -> 세미콜론을 여기에

    View.OnLongClickListener longClick = new View.OnLongClickListener() {
        public boolean onLongClick(View view) {
            textView.setText("Moblie Software");
            return true;
        }
    };


    View.OnTouchListener myTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
           // motionEvent.getAction() == MotionEvent.ACTION_DOWN;

            motionEvent.getX();

            return false;
        }
    };

}