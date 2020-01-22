package kr.co.ch09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.ch09.http.HttpConnectionActivity;
import kr.co.ch09.retrofit.RetrofitTestActivity;

/*
    날짜: 2020/01/22
    이름: 박준호
    내용 : 안드로이드 서버 통신

    서버통신 - http     : 비연결성
            - 소켓통신  : 열결성
 */
public class MainActivity extends AppCompatActivity {

    private Button btnHttp, btnRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHttp = findViewById(R.id.btn_http);
        btnRetrofit = findViewById(R.id.btn_retrofit);

        btnHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HttpConnectionActivity.class);
                startActivity(intent);
            }
        });

        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RetrofitTestActivity.class);
                startActivity(intent);
            }
        });
    }
}
