package ddwucom.mobile.week09.adapterclicktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SubjectManager subjectManager;
    ArrayList<String> subjectList;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;
    int selectedPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectManager = new SubjectManager();
        subjectList = subjectManager.getSubjectList();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjectList);

        editText = findViewById(R.id.etItem);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                editText.setText(subjectManager.getSubjectByPos(pos));
                selectedPos = pos;
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                subjectManager.removeData(position);
                adapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    public void onClick(View v){
        String text = editText.getText().toString();

        switch(v.getId()) {
            case R.id.btnInsert:
                subjectManager.addData(text);
                editText.setText("");
                adapter.notifyDataSetChanged();
                break;

            case R.id.btnUpdate:
                subjectManager.updateData(selectedPos, text);
                adapter.notifyDataSetChanged();
                break;
        }
    }

}
