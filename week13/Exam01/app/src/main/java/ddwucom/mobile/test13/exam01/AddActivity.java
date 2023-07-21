package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    FoodDBHelper myDbHelper;
    EditText etAddFood;
    EditText etAddNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        myDbHelper = new FoodDBHelper(this);
        etAddFood = findViewById(R.id.etAddFood);
        etAddNation = findViewById(R.id.etAddNation);
    }

    public void onClick(View v){

        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();

        switch(v.getId()){
            case R.id.btnAddFood:
                //메소드 사용
                ContentValues row = new ContentValues();

                row.put(FoodDBHelper.COL_FOOD, etAddFood.getText().toString());
                row.put(FoodDBHelper.COL_NATION, etAddNation.getText().toString());

                myDB.insert(FoodDBHelper.TABLE_NAME, null, row);

                //SQL문을 사용할 경우
                //String food = "김치찌개";
                //myDB.execSQL("insert into " + FoodDBHelper.TABLE_NAME + " values (null, '" + food + "','한국')");

                break;
        }
        myDbHelper.close();
        finish();
    }
}
