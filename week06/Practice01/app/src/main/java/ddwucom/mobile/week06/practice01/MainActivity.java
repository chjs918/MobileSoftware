package ddwucom.mobile.week06.practice01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btnDisplay);
      //  MyClick myClick = new MyClick();

        //3. 익명내부클래스의 임시객체구현
        button.setOnClickListener( new View.OnClickListener() {
                           public void onClick(View view) {
                               EditText editText = findViewById(R.id.editText);
                               String text = editText.getText().toString();
                               TextView tv = findViewById(R.id.tvDisplay);
                               tv.setText(text);
                           }
                       } );
    }

    //1. 별도의 리스너 인터페이스 구현
//    class MyClick implements View.OnClickListener {
//        @Override
//        public void onClick(View view) {
//            EditText editText = findViewById(R.id.editText);
//            String text = editText.getText().toString();
//            TextView tv = findViewById(R.id.tvDisplay);
//            tv.setText(text);
//        }
//    }

    //2. 익명 내부 클래스 구현
//    View.OnClickListener myInterfaceClick = new View.OnClickListener() {
//        public void onClick(View view) {
//            EditText editText = findViewById(R.id.editText);
//            String text = editText.getText().toString();
//            TextView tv = findViewById(R.id.tvDisplay);
//            tv.setText(text);
//        }
//    };
}