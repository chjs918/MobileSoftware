package ddwucom.mobile.week03.viewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText; //멤버변수로 만든다

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText); //버튼누를때마다찾으면 비효율적이라서 create된후에 한번만 찾게
    }

    public void onMyClick (View v) {
        switch(v.getId()) {
            case R.id.btn_okay:
                String str = editText.getText().toString();
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cancel:
                editText.setText("");
                break;
        }


    }
}