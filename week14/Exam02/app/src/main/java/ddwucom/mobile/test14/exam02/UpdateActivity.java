package ddwucom.mobile.test14.exam02;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    Food food;
    EditText etFood;
    EditText etNation;
    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        food = (Food) getIntent().getSerializableExtra("food");

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);

        //food, nation 자리에 음식명과 나라명이 뜬다
        etFood.setText(food.getFood());
        etNation.setText(food.getNation());

        foodDBManager = new FoodDBManager(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
                food.setFood(etFood.getText().toString());
                food.setNation(etNation.getText().toString());

                if(foodDBManager.modifyFood(food)) { //업데이트 잘됨
                    //startActivity하는 거아니다 이미 매인 위에 업데이트액티비티가 있기땜에 사라지기만하면 메인이 드러난다
                    Intent resultInent = new Intent();
                    resultInent.putExtra("food", food);
                    setResult(RESULT_OK, resultInent);
                } else { //실패
                    setResult(RESULT_CANCELED);
                }
                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
