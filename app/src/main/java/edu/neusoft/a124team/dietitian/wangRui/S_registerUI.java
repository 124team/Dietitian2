package edu.neusoft.a124team.dietitian.wangRui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.neusoft.a124team.dietitian.R;

public class S_registerUI extends AppCompatActivity {
    private Button speedRegister,commonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_register_ui);
        speedRegister = (Button) findViewById(R.id.s_phone_register);
        commonRegister = (Button) findViewById(R.id.s_common_register);

        speedRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(S_registerUI.this,S_register.class);
                startActivity(i);
            }
        });
        commonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(S_registerUI.this,S_quickRegistration.class);
                startActivity(i);
            }
        });
    }
}
