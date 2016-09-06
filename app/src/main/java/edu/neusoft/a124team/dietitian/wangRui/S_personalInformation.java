package edu.neusoft.a124team.dietitian.wangRui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import edu.neusoft.a124team.dietitian.R;

public class S_personalInformation extends AppCompatActivity {
    private EditText nameText,ageText,emailText;
    private ImageView imgReturn;
    private TextView saveText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_personal_information);
        nameText = (EditText)this.findViewById(R.id.s_personal_nickName);
        ageText = (EditText)this.findViewById(R.id.s_personal_age);
        emailText = (EditText)this.findViewById(R.id.s_personal_email);
        saveText = (TextView)this.findViewById(R.id.s_personal_save);
        //自定义bar//
        imgReturn = (ImageView) this.findViewById(R.id.s_return_page);
        imgReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        saveText.setOnClickListener(listener);
        // 回显
        SharedPreferences sharedPreferences=getSharedPreferences("ljq123",
                Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE+Context.MODE_WORLD_WRITEABLE);
        String nameValue = sharedPreferences.getString("name", "");
        int ageValue = sharedPreferences.getInt("age", 1);
        String emailValue=sharedPreferences.getString("email","");
        nameText.setText(nameValue);
        ageText.setText(String.valueOf(ageValue));
        emailText.setText(emailValue);
    }

    private View.OnClickListener listener = new View.OnClickListener(){
        public void onClick(View v) {

            SharedPreferences sharedPreferences=getSharedPreferences("ljq123",
                    Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE+Context.MODE_WORLD_WRITEABLE);
                    String name = nameText.getText().toString();
                    int age = Integer.parseInt(ageText.getText().toString());
                    String eamil = emailText.getText().toString();
                    SharedPreferences.Editor editor = sharedPreferences.edit(); //获取编辑器
                    editor.putString("name", name);
                    editor.putInt("age", age);
                    editor.putString("email", eamil);
                    editor.commit();//提交修改
                    Toast.makeText(S_personalInformation.this, "保存成功", Toast.LENGTH_LONG).show();
        }
    };
}
