package edu.neusoft.a124team.dietitian.wangRui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import edu.neusoft.a124team.dietitian.R;

public class S_register extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_register);
        setTitle("注册选择");
        btn=(Button)findViewById(R.id.s_quickRegistration_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(S_register.this,S_quickRegistration.class);
                startActivity(i);
            }
        });

    }
}
