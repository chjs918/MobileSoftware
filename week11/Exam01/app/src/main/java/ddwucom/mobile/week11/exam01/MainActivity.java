package ddwucom.mobile.week11.exam01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList;
    FoodManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = new FoodManager();

        listView = findViewById(R.id.listView);

        foodList = manager.foodList;

        foodList = manager.getFoodList();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                final int index = position;
                String food = foodList.get(position).getFood();

                //다이얼로그 기능
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("음식 삭제")
                        .setMessage(food + "(을)를 삭제하시겠습니까? ")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                manager.deleteFood(index);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });
    }

    public void onClick(View v){
        final ConstraintLayout plusLayout = (ConstraintLayout) View.inflate(this, R.layout.plus_layout, null);

        switch (v.getId()){
            case R.id.button:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(" 음식 추가 ")
                        .setView(plusLayout)
                        .setPositiveButton("추가 ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText edProduct = plusLayout.findViewById(R.id.edProduct);
                                EditText edQuantity = plusLayout.findViewById(R.id.edQuantity);

                                String name = edProduct.getText() + " ";
                                String country = edQuantity.getText() + " ";

                                manager.addFood(new Food(name, country));
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소 ", null)
                        .show();
                break;
        }
    }

}
