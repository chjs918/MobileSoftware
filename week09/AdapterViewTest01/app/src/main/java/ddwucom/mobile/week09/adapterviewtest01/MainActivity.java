package ddwucom.mobile.week09.adapterviewtest01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> subjectList = new ArrayList<String>();
        subjectList.add("노르웨이숲");
        subjectList.add("러시안블루");
        subjectList.add("코리안숏헤어");
        subjectList.add("먼치킨");
        subjectList.add("터키시앙고라");
        subjectList.add("페르시안");
        subjectList.add("스코티시폴드");

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, subjectList);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}