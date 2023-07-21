package ddwucom.mobile.week04.practice01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String num1="";
    int no1, no2, total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        editText = findViewById(R.id.etDisplay);
    }

    public void onClick(View v){
        String text = editText.getText().toString();

        switch(v.getId()){
            case R.id.btn_1:
                num1 += "1";
                editText.setText(num1);
                break;
            case R.id.btn_2:
                num1 += "2";
                editText.setText(num1);
                break;
            case R.id.btn_plus:
                no1 = Integer.parseInt(num1);
                num1 = "";
                editText.setText(num1);
                break;
            case R.id.btn_equal:
                no2 = Integer.parseInt(num1);
                total = no1 + no2;
                num1 = Integer.toString(total);
                editText.setText(num1);
                break;
        }
    }
}