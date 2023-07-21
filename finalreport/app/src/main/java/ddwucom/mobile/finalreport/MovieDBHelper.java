package ddwucom.mobile.finalreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MovieDBHelper extends SQLiteOpenHelper {
    final static String TAG = "MovieDBHelper";

    final static String DB_NAME = "movies.db";
    public final static String TABLE_NAME = "movie_table";

    public final static String COL_ID = "_id";
    public final static String COL_TITLE = "title";
    public final static String COL_DIRECTOR = "director";
    public final static String COL_YEAR = "year";
    public final static String COL_GENRE = "genre";
    public final static String COL_GRADE = "grade";

    public MovieDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_TITLE + " TEXT, " + COL_DIRECTOR + " TEXT, " + COL_YEAR + " TEXT, " +
                COL_GENRE + " TEXT, " + COL_GRADE + " integer)";
        Log.d(TAG, sql);
        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME + " values (null, '겨울왕국', '크리스 벅, 제니퍼 리', '2014', '애니메이션', 4);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '센과 치히로의 행방불명', '미야자키 하야오', '2001', '애니메이션', 4);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '신과함께: 죄와 벌', '김용화', '2017', '드라마', 4);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '도둑들', '최동훈', '2012', '액션', 1);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '왕의 남자', '이준익', '2005', '드라마', 3);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '해운대', '윤제균', '2009', '드라마', 5);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
