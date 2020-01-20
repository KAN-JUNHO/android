package kr.co.ch07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.ch07.pref.PreferenceActivity;
import kr.co.ch07.sqlite.SQLiteActivity;



/*
    날짜 : 2020/01/20
    이름 : 김철학
    내용 : 안드로이드 데이터 영속화

    프레퍼런스(cf: 아이폰 -> 아카이브)
     - 안드로이드에서 사용하는 임시 저장소(XML파일)
     - 앱 설정 데이터를 저장, 보관

    SQLite
     - 가벼운 데이터베이스
     - 기본적인 SQL문을 지원

 */
public class MainActivity extends AppCompatActivity {

    Button btnPref, btnSqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPref = findViewById(R.id.btn_pref);
        btnSqlite = findViewById(R.id.btn_sqlite);

        btnPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, PreferenceActivity.class);
                startActivity(intent);

            }
        });

        btnSqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SQLiteActivity.class);
                startActivity(intent);
            }
        });



    }
}
