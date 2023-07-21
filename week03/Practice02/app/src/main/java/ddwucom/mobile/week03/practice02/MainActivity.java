package ddwucom.mobile.week03.practice02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }

    public void onClick (View v) {
        String num = editText.getText().toString();
        switch(v.getId()){
            case R.id.btnOne:
                num += "1";
                editText.setText(num);
                break;
            case R.id.btnTwo:
                num += "2";
                editText.setText(num);
                break;
            case R.id.btnThree:
                num += "3";
                editText.setText(num);
                break;
            case R.id.btnClear:
                editText.setText("");
                num = "";
                break;
        }
    }
}