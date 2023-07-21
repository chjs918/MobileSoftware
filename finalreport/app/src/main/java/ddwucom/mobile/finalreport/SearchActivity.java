package ddwucom.mobile.finalreport;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {
    MovieDBManager movieDBManager = null;
    TextView title, director, year, genre, grade;
    ImageView imageView;
    EditText editText;
    Cursor cursor;
    String[] columns = new String[]{"_id", "title", "director", "year", "genre", "grade"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        movieDBManager = new MovieDBManager(this);

        title = findViewById(R.id.title_search);
        director = findViewById(R.id.director_search);
        year = findViewById(R.id.year_search);
        genre = findViewById(R.id.genre_search);
        grade = findViewById(R.id.grade_search);
        imageView = findViewById(R.id.image_search);
        editText = findViewById(R.id.etSearch);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSearch:
                int pos = -1;
                cursor = movieDBManager.query(columns, MovieDBHelper.COL_TITLE + "='" + editText.getText().toString() + "'", null, null, null, null);

                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        pos = cursor.getInt(0);
                        title.setText("영화 제목: " + cursor.getString(1));
                        director.setText("감독: " + cursor.getString(2));
                        year.setText("개봉년도: " + cursor.getString(3));
                        genre.setText("장르: " + cursor.getString(4));
                        grade.setText("평점: " + cursor.getString(5));
                    }
                }
                if (pos == 1) {
                    imageView.setImageResource(R.drawable.frozen);
                } else if (pos == 2) {
                    imageView.setImageResource(R.drawable.sen);
                } else if (pos == 3) {
                    imageView.setImageResource(R.drawable.withgod);
                } else if (pos == 4) {
                    imageView.setImageResource(R.drawable.doduk);
                } else if (pos == 5) {
                    imageView.setImageResource(R.drawable.kingman);
                } else {
                    imageView.setImageResource(R.drawable.busan);
                }

                break;
            case R.id.btnHome:
                finish();
                break;
        }
    }
}