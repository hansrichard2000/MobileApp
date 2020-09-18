package com.uc.hans_0706011910007;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import com.uc.hans_0706011910007.model.User;

public class UserDetailActivity extends AppCompatActivity {

    TextView fname, age, address;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserDetailActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        fname = findViewById(R.id.fname);
        age = findViewById(R.id.age2);
        address = findViewById(R.id.address2);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra("listusers");

        fname.setText(user.getFname());
        age.setText(user.getAge());
        address.setText(user.getAddress());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        NavUtils.navigateUpFromSameTask(this);

    }
}
