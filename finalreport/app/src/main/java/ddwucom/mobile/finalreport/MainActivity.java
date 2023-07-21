//과제명: 영화 정보 관리 앱
//분반: 02분반
//학번: 20201028 성명: 최지수
//제출일: 2022년 06월 24일
//추가 기능 - 위젯사용 (평점 입력시 RatingBar 위젯을 사용)
//        - 이미지 사용
//        - 검색기능 (메뉴에 영화 제목 검색항목 추가해서 구현)
package ddwucom.mobile.finalreport;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ListView listView;
    ArrayList<MovieData> movieDataList;
    MovieAdapter adapter;
    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        movieDataList = new ArrayList<MovieData>();
        movieDBManager = new MovieDBManager(this);
        adapter = new MovieAdapter(this, R.layout.custom_adapter_view, movieDataList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MovieData movie = movieDataList.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("movie", movie);
                startActivityForResult(intent, UPDATE_CODE);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("영화 삭제")
                        .setMessage(movieDBManager.getMovie().get(pos).getTitle() + "를 삭제하시겠습니까?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (movieDBManager.removeMovie(movieDataList.get(pos).get_id())) {
                                    Toast.makeText(MainActivity.this, "삭제 완료", Toast.LENGTH_SHORT).show();
                                    movieDataList.clear();
                                    movieDataList.addAll(movieDBManager.getMovie());
                                    adapter.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(MainActivity.this, "삭제 실패", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                return true;
            }
        });
    }
    protected void onResume() {
        super.onResume();
        movieDataList.clear();
        movieDataList.addAll(movieDBManager.getMovie());
        adapter.notifyDataSetChanged();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnAdd:
                Toast.makeText(this,"영화를 추가합니다",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent,REQ_CODE);
                break;
            case R.id.mnSearch:
                Intent intent4 = new Intent(MainActivity.this, SearchActivity.class);
                startActivityForResult(intent4, REQ_CODE);
                break;
            case R.id.mnInfo:
                Toast.makeText(this, "개발자 소개합니다.",
                        Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, InfoActivity.class);
                startActivity(intent2);
                break;
            case R.id.mnExit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("앱 종료")
                        .setMessage("앱을 종료하시겠습니까?")
                        .setNegativeButton("취소버튼", null)
                        .setPositiveButton("종료버튼", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                        .show();
                break;
        }
        return true;
    }
}