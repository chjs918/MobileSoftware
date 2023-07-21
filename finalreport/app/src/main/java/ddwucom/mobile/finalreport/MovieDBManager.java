package ddwucom.mobile.finalreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MovieDBManager {
    MovieDBHelper movieDBHelper = null;
    Cursor cursor = null;

    public MovieDBManager(Context context) {
        movieDBHelper = new MovieDBHelper(context);
    }

    public ArrayList<MovieData> getMovie(){
        ArrayList movieList = new ArrayList();
        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + MovieDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_TITLE));
            String director = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_DIRECTOR));
            String year = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_YEAR));
            String genre = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_GENRE));
            int grade = cursor.getInt(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_GRADE));

            movieList.add (new MovieData(id, title, director, year, genre, grade));
        }

        cursor.close();
        movieDBHelper.close();
        return movieList;
    }
    public boolean addNewMovie(MovieData newMovieData) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put(MovieDBHelper.COL_TITLE, newMovieData.getTitle());
        value.put(MovieDBHelper.COL_DIRECTOR, newMovieData.getDirector());
        value.put(MovieDBHelper.COL_YEAR, newMovieData.getYear());
        value.put(MovieDBHelper.COL_GENRE, newMovieData.getGenre());
        value.put(MovieDBHelper.COL_GRADE, newMovieData.getGrade());

        long count = db.insert(MovieDBHelper.TABLE_NAME, null, value);
        movieDBHelper.close();

        if (count > 0)
            return true;

        return false;
    }

    public boolean modifyMovie(MovieData movieData) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        ContentValues row = new ContentValues();

        row.put(MovieDBHelper.COL_TITLE, movieData.getTitle());
        row.put(MovieDBHelper.COL_DIRECTOR, movieData.getDirector());
        row.put(MovieDBHelper.COL_YEAR, movieData.getYear());
        row.put(MovieDBHelper.COL_GENRE, movieData.getGenre());
        row.put(MovieDBHelper.COL_GRADE, movieData.getGrade());

        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(movieData.get_id()) };

        int result = sqLiteDatabase.update(MovieDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        movieDBHelper.close();

        if (result > 0)
            return true;

        return false;
    }

    public boolean removeMovie(long id) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };

        int result = sqLiteDatabase.delete(MovieDBHelper.TABLE_NAME, whereClause,whereArgs);
        movieDBHelper.close();

        if (result > 0)
            return true;

        return false;
    }
    public Cursor query(String[] colums,
                        String selection,
                        String[] selectionArgs,
                        String groupBy,
                        String having,
                        String orderby)
    {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        return sqLiteDatabase.query(MovieDBHelper.TABLE_NAME,
                colums,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderby);
    }
}
