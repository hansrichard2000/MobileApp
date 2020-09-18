package com.uc.hans_0706011910007;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import com.uc.hans_0706011910007.dialog.DeleteActivity;
import com.uc.hans_0706011910007.model.SimpanData;
import com.uc.hans_0706011910007.model.User;

import java.util.ArrayList;

public class UserDetailActivity extends AppCompatActivity {

    private static final String TAG ="try";
    TextView fname, age, address;
    Toolbar toolbar;
    ImageButton edit, delete;
    ArrayList<User>listUsers = SimpanData.listUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fname = findViewById(R.id.fname2);
        age = findViewById(R.id.age2);
        address = findViewById(R.id.address2);

        Intent intent = getIntent();
        final int position = intent.getIntExtra("pos", 0);
        User user = intent.getParcelableExtra("listUsers");
//        Log.d(TAG, "onCreate:" + user.toString());

        fname.setText(user.getFname());
        age.setText(user.getAge()+" Years Old");
        address.setText(user.getAddress());

        edit = findViewById(R.id.button_edit);
        delete = findViewById(R.id.button_delete);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserDetailActivity.this, AddUserActivity.class);
                intent.putExtra("listUsers", listUsers.get(position));
                intent.putExtra("position", position);
                startActivity(intent);
                finish();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteDialog();
            }
        });
    }

    private void deleteDialog() {
        DeleteActivity deleteActivity;
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(UserDetailActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
