package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        myDbHelper = new FoodDBHelper(this);
    }


    public void onClick(View v) {

        SQLiteDatabase myDB = myDbHelper.getWritableDatabase();
        //     SQLiteDatabase myDB = myDbHelper.getReadableDatabase();
        switch(v.getId()) {
            case R.id.btnSelect:
//                String selection = "food=?";
//                String[] selectArgs = new String[]{"된장찌개"};
//                String[] columns = {"_id", "food", "nation"};
//
//                Cursor cursor =
//                        myDB.query(FoodDBHelper.TABLE_NAME, null, selection,
//                                null, null, null, null, null);
//
                Cursor cursor = myDB.rawQuery("select * from "+FoodDBHelper.TABLE_NAME
                        ,null);

                String result ="";
                while(cursor.moveToNext()){
                    result += cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID)) + " : ";
                    result += cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD)) + " : ";
                    result += cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION)) + " \n ";

                }

                tvDisplay.setText(result);
                cursor.close();//커서도 종료시켜준다!!!

                break;

            case R.id.btnAdd:
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                break;

//                //메소드 사용
//                ContentValues row = new ContentValues();
//                row.put(FoodDBHelper.COL_FOOD, "깐풍기");
//                row.put(FoodDBHelper.COL_NATION, "중국");
//                myDB.insert(FoodDBHelper.TABLE_NAME, null,row); //가능하면 이방법으로
//
//                //SQL이용
//                String food = "피자";
//                myDB.execSQL("insert into "+ FoodDBHelper.TABLE_NAME
//                + " values ( null, '" + food+ "', '미쿡')");


            case R.id.btnUpdate:
                Intent intent2 = new Intent(this, UpdateActivity.class);
                startActivity(intent2);
                break;

//                ContentValues row2 = new ContentValues();
//                row2.put("nation", "KFC");
//                row2.put("food", "chicken");
//                String whereClause = "food=? and nation=?";
//                String[] whereArgs = new String[] {"한국", "된장찌개"};
//
//                myDB.update(FoodDBHelper.TABLE_NAME, row2, whereClause, whereArgs);
//
//                myDB.execSQL("UPDATE " + FoodDBHelper.TABLE_NAME+" SET nation= '한국', food= '떡볶이' WHERE _id= '5'" );

            case R.id.btnRemove:
                Intent intent3 = new Intent(this, RemoveActivity.class);
                startActivity(intent3);
                break;

//                String whereClause2 = "_id = '1'";
//                myDB.delete(FoodDBHelper.TABLE_NAME, whereClause2,null);

        }

        myDbHelper.close();}

}
