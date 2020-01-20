package kr.co.ch07.pref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import kr.co.ch07.R;

public class PreferenceActivity extends AppCompatActivity {

    private Button btnSave, btnConfirem;
    private EditText edtUid, edtName, edtHp;
    private Spinner spnnPos, spnnDep;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        btnConfirem = findViewById(R.id.btn_confirm);
        btnSave = findViewById(R.id.btn_save);
        edtUid = findViewById(R.id.edt_uid);
        edtName = findViewById(R.id.edt_name);
        edtHp = findViewById(R.id.edt_hp);
        spnnPos = findViewById(R.id.spnn_pos);
        spnnDep = findViewById(R.id.spnn_dep);

        btnConfirem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PreferenceActivity.this, PreferenceConfirmActivity.class);
                startActivity(intent);

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // SharedPrefence 생성 및 초기화
                SharedPreferences pf = getSharedPreferences("CH07_MEMBER", MODE_PRIVATE);
                SharedPreferences.Editor edit = pf.edit();

                String uid = edtUid.getText().toString();
                String name = edtName.getText().toString();
                String hp = edtHp.getText().toString();
                String pos = spnnPos.getSelectedItem().toString();
                String dep = spnnDep.getSelectedItem().toString();

                // SharedPrefence 저장
                edit.putString("uid", uid);
                edit.putString("name", name);
                edit.putString("hp", hp);
                edit.putString("pos", pos);
                edit.putInt("dep", Integer.parseInt(dep));

                // 저장실행
                edit.commit();

                Toast.makeText(PreferenceActivity.this, "잘 저장 되었습니다.", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
