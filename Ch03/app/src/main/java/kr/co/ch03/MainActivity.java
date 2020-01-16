package kr.co.ch03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1;
    private Button btn2;
    private Button btn3, btn4;

    private EditText edtContent;
    private Button btnComplete;
    private TextView txtResult;

    private CheckBox chk1, chk2, chk3, chk4, chk5;
    private Button btnHobbyConfirm;
    private Set<String> hobbies = new HashSet<>();

    private Switch swt;

    private Spinner spnn1;
    private Spinner spnn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        edtContent = findViewById(R.id.edt_content);
        btnComplete = findViewById(R.id.btn_complete);
        txtResult = findViewById(R.id.txt_result);

        chk1 = findViewById(R.id.chk_1);
        chk2 = findViewById(R.id.chk_2);
        chk3 = findViewById(R.id.chk_3);
        chk4 = findViewById(R.id.chk_4);
        chk5 = findViewById(R.id.chk_5);
        btnHobbyConfirm = findViewById(R.id.btn_hobby_confirm);
        btnHobbyConfirm.setOnClickListener(this);

        swt = findViewById(R.id.swt);

        spnn1 = (Spinner) findViewById(R.id.spnn1);
        spnn2 = (Spinner) findViewById(R.id.spnn2);



        spnn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "선택 : " +spnn1.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        swt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b==true){
                    swt.setText("스위치켜짐");
                }else {
                    swt.setText("스위치꺼짐");

                }
            }
        });



        //입력 완료 버튼 클릭
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Editable txt = edtContent.getText();
                txtResult.setText(txt);
            }
        });

        //기본 방식 : 직접 버튼에 리스너를 구현
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼1 클릭!", Toast.LENGTH_SHORT).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼2 클릭!", Toast.LENGTH_LONG).show();
            }
        });
        //리스너를 외부객체로 구현해서 버튼과 연결하는 방식
        btn3.setOnClickListener(btn3Listner);
        btn4.setOnClickListener(btn4Listner);

    }//onCreate End


    @Override
    public void onClick(View view) {
        //취미 확인 버튼을 클릭

        String strHobby = "";

        Iterator it = hobbies.iterator();

        while (it.hasNext()){

            strHobby += it.next();

        }

        Toast.makeText(MainActivity.this, strHobby+"입니다.", Toast.LENGTH_SHORT).show();

    }

    public void checkListener(View v){
        switch (v.getId()){

            case R.id.chk_1:
                hobbies.add("등산");
                break;
            case R.id.chk_2:
                hobbies.add("영화");
                break;
            case R.id.chk_3:
                hobbies.add("게임");
                break;
            case R.id.chk_4:
                hobbies.add("운동");
                break;
            case R.id.chk_5:
                hobbies.add("독서");
                break;


        }
    }


    View.OnClickListener btn3Listner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // 안드로이드 대화상자 출력
            new AlertDialog.Builder(MainActivity.this)
                    .setIcon(R.mipmap.ic_launcher)
                    .setTitle("알림")
                    .setMessage("wow")
                    .show();
        }
    };
    View.OnClickListener btn4Listner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("확인");
            dialog.setMessage("버튼4를 눌렀습니다.");
            dialog.setNegativeButton("취소",null);
            dialog.setPositiveButton("확인",null);
            dialog.show();
        }
    };

    //레이아웃파일에  onClick속성 리스너를 구현하는 방식
    public void btn5Listener(View view){
        Toast.makeText(MainActivity.this, "버튼5클릭!",Toast.LENGTH_SHORT).show();
    }

    public void btn6Listener(View view){
        Toast.makeText(getApplicationContext(), "버튼6클릭!",Toast.LENGTH_SHORT).show();
    }


}

