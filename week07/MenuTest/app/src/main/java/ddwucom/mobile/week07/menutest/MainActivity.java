package ddwucom.mobile.week07.menutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        registerForContextMenu(textView);
    }

    //ctrl+o 하면 오버라이드메소드 뜸
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //MenuInflater menuInflater = getMenuInflater();

        //매개변수 객체 menu(빈 메뉴)에 전달
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        //더이상 할필요 x- true, 더 해줘야한다 - false
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Item_ch01:
                Toast.makeText(this, "짜장면은 정말 마시썽", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_ch02:
                Toast.makeText(this, "짬뽕은 정말 마시썽", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_k01:
                Toast.makeText(this, "김치찌개는 정말 마시썽", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_k02:
                Toast.makeText(this, "순두부찌개는 정말 마시썽", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public void onMenuClick(MenuItem item) {
        Toast.makeText(this, "Sub01 Click!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.textView:
                getMenuInflater().inflate(R.menu.activity_menu, menu);
                break;
        }
    }


}

