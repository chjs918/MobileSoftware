package ddwucom.mobile.week11.dialogtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int selectedItem = 0;
    boolean[] selectedItems = {false, false, false, false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        final ConstraintLayout orderLayout = (ConstraintLayout) View.inflate(this, R.layout.order_layout,null);

        switch(v.getId()){
            case R.id.button:
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            //메소드 연속 호출 가능
            builder.setTitle("대화상자 제목");
            //1. 제목만표시
            //builder.setMessage("대화상자 메시지");
            //2.목록 표시
//            builder.setItems(R.array.foods, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    //xml에서 배열을 얻어온다
//                    String[] foods = getResources().getStringArray(R.array.foods);
//                    Toast.makeText(MainActivity.this, "선택: " + foods[i], Toast.LENGTH_SHORT).show();
//                }
//            });
                //3. 라디오 버튼
//                builder.setSingleChoiceItems(R.array.foods, selectedItem, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        selectedItem = i;
//                    }
//                };
                //4. 체크박스
//                builder.setMultiChoiceItems(R.array.foods, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//                        selectedItems[i] = b;
//                    }
//                });

        //xml을 자바 객체로 만드는 작업
            builder.setView(orderLayout);
            builder.setIcon(R.mipmap.ic_launcher);
            //false-백버튼 눌러도 안닫힘
            builder.setCancelable(false);
            //ux)확인버튼은 보통 오른쪽, 휴대폰으로 자주 누르는버튼의 방향이 오른쪽이라서
            //   버튼 방향 바꾸고싶으면 네거티브버튼을 확인버튼으로!
            builder.setPositiveButton("확인버튼", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
//                    String[] foods = getResources().getStringArray(R.array.foods);
//                    String food = foods[selectedItem];
//                    //그냥 this치면 이벤트핸들러이다. MainActivity.this로 정확하게
//                    Toast.makeText(MainActivity.this,
//                            "확인!!!", Toast.LENGTH_SHORT).show();
//                    finish();
                    EditText etProduct = orderLayout.findViewById(R.id.etProduct);
                    String product = etProduct.getText().toString();

                    Toast.makeText(MainActivity.this, product, Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNeutralButton("대기버튼", null);
            builder.setNegativeButton("취소버튼" , null);

            //builder.show()와 같다!
//            Dialog dig = builder.create();
//            dig.setCanceledOnTouchOutside(false);
//            dig.show();

            builder.show();
            //Dialog dig = builder.create(); dig.show();를 한줄로 표현한거
            break;
        }
    }
}