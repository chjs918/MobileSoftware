package ddwucom.mobile.test14.exam02;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;

    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);

        //db를 쓰는 작업이 필요하니까 db헬퍼객체를 만들었음
        foodDBManager = new FoodDBManager(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                boolean result = foodDBManager.addNewFood(
                        new Food(etFood.getText().toString(), etNation.getText().toString())
                );
                //이상이 있을 경우는 0
                if (result) {    // 정상수행에 따른 처리
                    //결과를 담는 인텐트 하나 만든다.
                    //이때는 메인액티비티를 실행하는걸로 만들면 안된다
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("food", etFood.getText().toString() );
                    setResult(RESULT_OK, resultIntent);
                    //dbHelper.close();
                    finish();
                } else {        // 이상에 따른 처리 0이하인경우
                    Toast.makeText(this, "새로운 음식 추가 실패!", Toast.LENGTH_SHORT).show();
                    //dbHelper.close();
                }

                break;
            case R.id.btn_cancel:   // 취소에 따른 처리
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
