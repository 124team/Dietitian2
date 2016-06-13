package edu.neusoft.a124team.dietitian.wangRui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import edu.neusoft.a124team.dietitian.MainActivity;
import edu.neusoft.a124team.dietitian.R;
import edu.neusoft.a124team.dietitian.wangRui.userSqlite.SqliteDB;

public class S_loginUi extends AppCompatActivity {
    private Button btn;
    private EditText userName;
    private EditText passWord;
    private TextView txt;
    private ImageView imgReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_login_ui);


        //自定义bar//
        imgReturn = (ImageView) this.findViewById(R.id.s_return_page);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        //跳转注册//
        txt=(TextView)findViewById(R.id.s_login_registerTxt);
        //设置本地登录//
        btn = (Button) findViewById(R.id.s_login_btn);
        userName = (EditText) findViewById(R.id.s_userName_edt);
        passWord = (EditText) findViewById(R.id.s_passWord_edt);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(S_loginUi.this,S_quickRegistration.class);
                startActivity(i);

            }
        });



    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = userName.getText().toString().trim();
            String pass = passWord.getText().toString().trim();
                //userList=SqliteDB.getInstance(getApplicationContext()).loadUser();
            if (name.equals("")||pass.equals("")){
                Toast.makeText(getApplicationContext(), "用户名或密码不合法",
                        Toast.LENGTH_SHORT).show();
            }

            else {
                int checkName = SqliteDB.getInstance(getApplicationContext()).Quer(name);
                if (checkName == -1){
                    int checkpass = SqliteDB.getInstance(getApplicationContext()).PassCheck(pass,name);

                    if (checkpass == 1) {
                        Toast.makeText(getApplicationContext(), "登录成功" ,
                                Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(S_loginUi.this, MainActivity.class);
                        startActivity(i);

                    }

                    else {

                        Toast.makeText(getApplicationContext(), "密码错误",
                                Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(getApplicationContext(), "用户名不存在",
                            Toast.LENGTH_SHORT).show();
                }

            }
            }

    });
    }

}
