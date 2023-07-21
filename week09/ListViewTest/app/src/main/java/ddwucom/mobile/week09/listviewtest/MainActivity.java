package ddwucom.mobile.week09.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataManager dataManager;
    ArrayList<String> subjectList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dataManager = new DataManager();
        subjectList = dataManager.getSubjectList();

        //textView 하나만 들어있다
        //int i = android.R.layout.simple_list_item_1;

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                subjectList);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                        Toast.makeText(MainActivity.this, subjectList.get(pos), Toast.LENGTH_SHORT).show();();
                        //원본 데이터를 지우는 작업
                        //- 이것만 쓰면 원본데이터가 수정되었는데 화면은 그대로란 오류 뜬다
                        dataManager.removeData(pos);
                        adapter.notifyDataSetChanged();
                    }
                };

    }
}