package kr.co.ch07.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.ResultSet;

import kr.co.ch07.R;

public class SelectActivity extends AppCompatActivity {

    private LayoutInflater inflater;

    private LinearLayout layoutItem;
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        layoutItem = findViewById(R.id.layout_item);
        dbHelper = new DBHelper(this);

        // SELECT 실행
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM MEMBER;", null);


        while(cursor.moveToNext()){

            View view = inflater.inflate(R.layout.row_item_view, null);
            TextView txtUid = view.findViewById(R.id.txt_uid);
            TextView txtName = view.findViewById(R.id.txt_name);
            TextView txtHp = view.findViewById(R.id.txt_hp);
            TextView txtPos = view.findViewById(R.id.txt_pos);
            TextView txtDep = view.findViewById(R.id.txt_dep);

            String uid = cursor.getString(0);
            String name = cursor.getString(1);
            String hp = cursor.getString(2);
            String pos = cursor.getString(3);
            int dep = cursor.getInt(4);

            txtUid.setText(uid);
            txtName.setText(name);
            txtHp.setText(hp);
            txtPos.setText(pos);
            txtDep.setText(""+dep);

            layoutItem.addView(view);

        }

        cursor.close();
        dbHelper.close();

    }
}