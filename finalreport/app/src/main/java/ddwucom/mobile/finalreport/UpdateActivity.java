package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    MovieData movie;

    EditText etTitle;
    EditText etDirector;
    EditText etYear;
    EditText etGenre;
    RatingBar ratingBar;

    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        movie = (MovieData) getIntent().getSerializableExtra("movie");
        long pos = movie.get_id();

        etTitle = findViewById(R.id.etTitle2);
        etDirector = findViewById(R.id.etDirector2);
        etYear = findViewById(R.id.etYear2);
        etGenre = findViewById(R.id.etGenre2);
        ratingBar = findViewById(R.id.ratingBar2);
        ImageView imageU = findViewById(R.id.imageViewU);

        if(pos == 1) {
            imageU.setImageResource(R.drawable.frozen);
        } else if(pos == 2) {
            imageU.setImageResource(R.drawable.sen);
        } else if(pos == 3) {
            imageU.setImageResource(R.drawable.withgod);
        } else if(pos == 4) {
            imageU.setImageResource(R.drawable.doduk);
        } else if(pos == 5) {
            imageU.setImageResource(R.drawable.kingman);
        } else {
            imageU.setImageResource(R.drawable.busan);
        }

        etTitle.setHint(movie.getTitle());
        etDirector.setHint(movie.getDirector());
        etYear.setHint(movie.getYear());
        etGenre.setHint(movie.getGenre());
        ratingBar.setRating(movie.getGrade());

        movieDBManager = new MovieDBManager(this);
    }
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnUpdate:
                int gradeToInt = (int) ratingBar.getRating();
                if (etTitle.getText().toString().equals("") || gradeToInt==-1) {
                    Toast.makeText(this, "영화제목과 평점은 필수 입력 항목입니다", Toast.LENGTH_SHORT).show();
                }
                else {
                    movie.setTitle(etTitle.getText().toString());
                    movie.setDirector(etDirector.getText().toString());
                    movie.setYear(etYear.getText().toString());
                    movie.setGenre(etGenre.getText().toString());
                    movie.setGrade(gradeToInt);

                    if (movieDBManager.modifyMovie(movie)) {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("movie", movie);
                        setResult(RESULT_OK, resultIntent);
                    } else {
                        setResult(RESULT_CANCELED);
                    }
                    finish();
                }
                break;
            case R.id.btnCancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
