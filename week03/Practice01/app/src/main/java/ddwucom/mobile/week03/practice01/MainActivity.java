package ddwucom.mobile.week03.practice01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
    }

    public void onMyClick (View v) {
        switch(v.getId()){
            case R.id.btnHello:
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String str = "안녕하세요, 저는 " + name + "입니다.\n전화번호는 " + phone + "입니다.";

                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnExit:
                finish();
                break;
        }
    }
}