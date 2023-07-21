package ddwucom.mobile.test12.exam02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);
    }


    public void onClick(View v) {
//        버튼의 종류에 따라 결과 설정 후 finish()
        switch(v.getId()){
            case R.id.btn_add:
                Intent intent = new Intent();

                String food_name = etFood.getText().toString();
                String nation_name = etNation.getText().toString();
                Food food = new Food(food_name, nation_name);

                intent.putExtra("add_food", food);
                setResult(RESULT_OK, intent);
                break;
            case R.id.btn_cancel:
                Toast.makeText(this, "음식 추가 취소", Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}

