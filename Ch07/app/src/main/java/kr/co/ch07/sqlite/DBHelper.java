package kr.co.ch07.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "MEMBER.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE MEMBER ("+
                "uid TEXT PRIMARY KEY," +
                "name TEXT," +
                "hp TEXT," +
                "pos TEXT," +
                "dep INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS MEMBER");
        onCreate(db);

    }
}
