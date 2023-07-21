package ddwucom.mobile.week10.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SubActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        //textView찾아오고
        TextView textView = findViewById(R.id.textView2);

        //인텐트도 찾아오고
        Intent intent = getIntent();
        //put으로 집어넣은걸 get으로 꺼낸다
        String data = intent.getStringExtra("subject");

        textView.setText(data);

    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.sub_button_ok:
                //결과를 담기위한 인텐트
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result_Data", "subActivity returns data");
                setResult(RESULT_OK, resultIntent);
                break;
            case R.id.sub_button_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
