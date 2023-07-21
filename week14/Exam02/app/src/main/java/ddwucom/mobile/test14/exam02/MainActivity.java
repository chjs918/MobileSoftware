package ddwucom.mobile.test14.exam02;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList = null;
   // FoodDBHelper dbHelper;
    FoodDBManager foodDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        foodList = new ArrayList<Food>();

        adapter = new ArrayAdapter<Food>(this, android.R.layout.simple_list_item_1, foodList);
        listView.setAdapter(adapter);
        foodDBManager = new FoodDBManager(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id){
                Food food = foodList.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);

                //Food 객체 자체가 serializable 인터페이스를 구현하는 객체로 만들어져 있기 때문이다.
                intent.putExtra("food", food);
                startActivityForResult(intent, UPDATE_CODE);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                //문자열 넣어도되는데 나중에 교체생각해서 string.xml것을 가져온다다
               builder.setTitle(R.string.dialog_title)
                        .setMessage(R.string.dialog_message)
                        .setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //길어지면복잡하니까 메소드 정의후 불러옴
                                //deleteRecord(pos);

                                //foodList.get(pos)=pos위치의 Food 객체
                                boolean result = foodDBManager.removeFood(foodList.get(pos).get_id());
                                if(result ) {
                                    Toast.makeText(MainActivity.this,"삭제 완료", Toast.LENGTH_SHORT).show();
                                    foodList.clear();
                                    foodList.addAll(foodDBManager.getAllFood());
                                    adapter.notifyDataSetChanged();
                                } else{
                                    Toast.makeText(MainActivity.this,"삭제 실패", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton(R.string.dialog_cancel, null)
                       //다른부분눌러도 취소 안되고 버튼 눌러야 댐
                       .setCancelable(false)
                        .show();

                return true; //다이얼로그 정상적으로 끝났을때
            }
        });
    }

//    private void deleteRecord(int pos){
//        FoodDBHelper foodDBHelper = new FoodDBHelper(this);
//        SQLiteDatabase sqLiteDatabase = foodDBHelper.getWritableDatabase();
//
//        String whereClause = FoodDBHelper.COL_ID + "=?";
//        String[] whereArgs = new String[] { String.valueOf(foodList.get(pos).get_id()) };
//        int result = sqLiteDatabase.delete(FoodDBHelper.TABLE_NAME, whereClause,whereArgs);
//
//        if(result > 0) {
//            Toast.makeText(this,"삭제 완료", Toast.LENGTH_SHORT).show();
//            foodList.clear();
//            foodList.addAll(foodDBManager.getAllFood());
//            adapter.notifyDataSetChanged();
//       } else{
//            Toast.makeText(this,"삭제 실패", Toast.LENGTH_SHORT).show();
//        }
//        foodDBHelper.close();
//    }

    @Override
    protected void onResume(){
        super.onResume();
        //중복되니까 일단 비워
        foodList.clear();

        //foodList가 새로운 arrayList를 만들고 가리키는 바람에 ArrayAdapter와
        //다른 저장공간을 가리키게 돼서 foodList에만 반영되고 화면에느 반영이 안된다.

        //foodList = foodDBManager.getAllFood();

        //foodList는 그대로 가리켰던 저장공간 가리키고 새로운 저장공간의 수정된내용이
        //원래 저장공간에 추가돼서 화면에 반영된다.

        foodList.addAll(foodDBManager.getAllFood());

       // readAllFoods();
        //화면 내용 갱신해라!!
        adapter.notifyDataSetChanged();
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {  // AddActivity 호출 후 결과 확인
            switch (resultCode) {
                case RESULT_OK:
                    String food = data.getStringExtra("food");
                    Toast.makeText(this, food + " 추가 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "음식 추가 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if (requestCode == UPDATE_CODE) {    // UpdateActivity 호출 후 결과 확인
            switch (resultCode) {
                case RESULT_OK:
                    Toast.makeText(this, "음식 수정 완료", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "음식 수정 취소", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
