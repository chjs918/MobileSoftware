package ddwucom.mobile.week10.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int REQ_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
                //정확한 앱 지정 X,
                //내가 필요한 행동과 여기 필요한 데이터 제공 ->자동으로뜬다.
                //액션정보와 데이터만 주면 알아서 뜬다 = 묵시적 인텐트
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.google.com"));
//                Intent intent = new Intent(Intent.ACTION_DIAL,
//                        Uri.parse("tel:012-3456-7890"));
                startActivity(intent);
                //버튼을 누르면 새로운 액티비티를 띄운다
                //subActivity2 띄워라 -> 정확하게 해당 액티비티 컴포넌트 지정
                //이런 호출 방법은 명시적 인텐트 호출
//                Intent intent = new Intent(this, SubActivity2.class);
//
//                intent.putExtra("subject", "mobile Software");
//
//                startActivityForResult(intent, REQ_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE:
                if (resultCode == RESULT_OK) {
                    //결과 온거 받아서 출력
                    String resultData = data.getStringExtra("result_data");
                    Toast.makeText(this, resultData, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}