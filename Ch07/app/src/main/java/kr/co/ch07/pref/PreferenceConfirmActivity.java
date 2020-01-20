package kr.co.ch07.pref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import kr.co.ch07.R;

public class PreferenceConfirmActivity extends AppCompatActivity {

    private TextView txtUid;
    private TextView txtName;
    private TextView txtHp;
    private TextView txtPos;
    private TextView txtDep;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_confirm);

        txtUid = findViewById(R.id.txt_uid);
        txtName = findViewById(R.id.txt_name);
        txtHp = findViewById(R.id.txt_hp);
        txtPos = findViewById(R.id.txt_pos);
        txtDep = findViewById(R.id.txt_dep);

        SharedPreferences pref = getSharedPreferences("CH07_MEMBER",MODE_PRIVATE);

        String uid = pref.getString("uid","아이디없음");
        String name = pref.getString("name","이름없음");
        String hp = pref.getString("hp","번호없음");
        String pos = pref.getString("pos","직급 없음");
        int dep = pref.getInt("dep",0);

        txtUid.setText(uid);
        txtName.setText(name);
        txtHp.setText(hp);
        txtPos.setText(pos);
        txtDep.setText(""+dep);

    }
}
