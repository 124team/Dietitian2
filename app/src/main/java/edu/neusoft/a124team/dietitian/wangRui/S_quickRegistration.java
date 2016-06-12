package edu.neusoft.a124team.dietitian.wangRui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import edu.neusoft.a124team.dietitian.R;
import edu.neusoft.a124team.dietitian.wangRui.userSqlite.SqliteDB;
import edu.neusoft.a124team.dietitian.wangRui.userSqlite.User;

public class S_quickRegistration extends AppCompatActivity {

    private EditText edtName,edtPassWord;
    private Button btn;
    private ImageView imgReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_quick_registration);

        //自定义bar//
        imgReturn = (ImageView) this.findViewById(R.id.s_return_page);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        edtName=(EditText)findViewById(R.id.s_register_userName);
        edtPassWord=(EditText)findViewById(R.id.s_register_passWord);
        btn=(Button)findViewById(R.id.s_register_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString().trim();
                String pass = edtPassWord.getText().toString().trim();

                User user = new User();
                user.setUsername(name);
                user.setUserpwd(pass);
                int result = SqliteDB.getInstance(getApplicationContext()).saveUser(user);
                if (name.equals("") || pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "用户名或密码不合法！",
                            Toast.LENGTH_SHORT).show();
                    }
                else {
                    if (result == 1) {
                        Toast.makeText(getApplicationContext(), "注册成功",
                                Toast.LENGTH_SHORT).show();
                    }

                    else if(result==-1) {
                    Toast.makeText(getApplicationContext(), "用户名已存在",
                            Toast.LENGTH_SHORT).show();
                    }

                    else if(result==0) {
                        Toast.makeText(getApplicationContext(), "!",
                                Toast.LENGTH_SHORT).show();
                    }

                  /*  else if (result==1){
                        Toast.makeText(getApplicationContext(), "用户名已存在",
                                Toast.LENGTH_SHORT).show();
                    }*/
                }
            }

            });

        }



}

