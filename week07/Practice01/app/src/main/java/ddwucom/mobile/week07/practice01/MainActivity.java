package ddwucom.mobile.week07.practice01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyCircle myCircle;
    int r, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCircle = findViewById(R.id.myCircle);
        r = myCircle.getR();

        registerForContextMenu(myCircle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_big:
                r += 20;
                myCircle.setR(r);
                myCircle.invalidate();
                break;
            case R.id.item_sm:
                r -= 20;
                myCircle.setR(r);
                myCircle.invalidate();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.myCircle:
                getMenuInflater().inflate(R.menu.context_menu, menu);
                onContextItemSelected(menu.getItem(id));
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.red:
                myCircle.setColor(Color.RED);
                myCircle.invalidate();
                id = 0;
                item.setChecked(true);
                break;
            case R.id.green:
                myCircle.setColor(Color.GREEN);
                myCircle.invalidate();
                id = 1;
                item.setChecked(true);
                break;
            case R.id.blue:
                myCircle.setColor(Color.BLUE);
                myCircle.invalidate();
                id = 2;
                item.setChecked(true);
                break;
        }
        return super.onContextItemSelected(item);
    }
}