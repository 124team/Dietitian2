package edu.neusoft.a124team.dietitian.wangRui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.neusoft.a124team.dietitian.MainActivity;
import edu.neusoft.a124team.dietitian.R;

public class S_loginUi extends AppCompatActivity {
    private Button btn;
    private EditText userName;
    private EditText passWord;
    private String userNameValue,passwordValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_login_ui);
        setTitle("登录");
        btn = (Button) findViewById(R.id.s_login_btn);
        userName = (EditText) findViewById(R.id.s_userName_edt);
        passWord = (EditText) findViewById(R.id.s_passWord_edt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取EDT的内容
                userNameValue = userName.getText().toString();
                passwordValue = passWord.getText().toString();

                if (userNameValue.equals("admin") && passwordValue.equals("123456")) {
                    Toast.makeText(S_loginUi.this, "登录成功", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(S_loginUi.this, MainActivity.class);
                    startActivity(intent);

                } else {

                    Toast.makeText(S_loginUi.this, "用户名或密码错误，请重新登录",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
