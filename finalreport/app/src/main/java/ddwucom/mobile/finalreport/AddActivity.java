package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    EditText etTitle;
    EditText etDirector;
    EditText etYear;
    EditText etGenre;
    RatingBar grade;

    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.etTitle);
        etDirector = findViewById(R.id.etDirector);
        etYear = findViewById(R.id.etYear);
        etGenre = findViewById(R.id.etGenre);
        grade = (RatingBar) findViewById(R.id.ratingBar);

        movieDBManager = new MovieDBManager(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                String title = etTitle.getText().toString();
                String director = etDirector.getText().toString();
                String year = etYear.getText().toString();
                String genre = etGenre.getText().toString();
                int gradeToInt = (int) grade.getRating();

                if (title.equals("") || year.equals("") || gradeToInt == -1) {
                    Toast.makeText(this, "필수 정보를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean result = movieDBManager.addNewMovie(
                            new MovieData(title, director, year, genre, gradeToInt));

                    if (result) {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("movie", etTitle.getText().toString());
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    } else {
                        Toast.makeText(this, "영화 추가 실패", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnCancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
