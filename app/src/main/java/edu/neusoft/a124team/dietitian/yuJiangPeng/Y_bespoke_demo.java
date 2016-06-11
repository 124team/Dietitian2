package edu.neusoft.a124team.dietitian.yuJiangPeng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import edu.neusoft.a124team.dietitian.R;

public class Y_bespoke_demo extends android.support.v7.app.AppCompatActivity {
  private Toolbar mtoolbar;
    private Button y_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.NoActionBar);
        setContentView(R.layout.activity_y_bespoke_demo);
        mtoolbar=(Toolbar)this. findViewById(R.id.y_bespoke_toolbar);
        mtoolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
       y_btn= (Button)this. findViewById(R.id.y_bespoke_btn);
        y_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Y_bespoke_demo.this,Y_popups_activity.class));
            }
        });

    }
}
