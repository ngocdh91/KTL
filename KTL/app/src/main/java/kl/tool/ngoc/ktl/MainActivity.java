package kl.tool.ngoc.ktl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    LinearLayout mLnShowExcercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mLnShowExcercise = (LinearLayout)findViewById(R.id.item1);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        mLnShowExcercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,DoExOneActivity.class);
                startActivity(i);
            }
        });

    }

}
