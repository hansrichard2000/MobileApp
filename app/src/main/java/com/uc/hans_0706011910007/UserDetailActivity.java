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
    User user;
    int position=0;
    ArrayList<User> listUsers = SimpanData.listUsers;
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
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        fname = findViewById(R.id.fname2);
        age = findViewById(R.id.age2);
        address = findViewById(R.id.address2);
        edit = findViewById(R.id.edit_user);
        delete = findViewById(R.id.delete_user);

        final Intent intent = getIntent();
        user = intent.getParcelableExtra("listUsers");
        position = intent.getIntExtra("position", 0);
//        Log.d(TAG, "onCreate:" + user.toString());

        fname.setText(user.getFname());
        age.setText(user.getAge()+ " Years Old");
        address.setText(user.getAddress());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(UserDetailActivity.this, AddUserActivity.class);
                intent1.putExtra("listUsers", listUsers.get(position));
                intent1.putExtra("arrayUsers", listUsers);
                intent1.putExtra("position", position);
                startActivity(intent1);
                finish();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogDelete();
            }
        });

    }

    private void openDialogDelete() {
//        Intent intent = new Intent(UserDetailActivity.this, DeleteActivity.class);
//        intent.putExtra("position", position);
//        startActivity(intent);
        DeleteActivity deleteActivity = new DeleteActivity(listUsers, position);
        deleteActivity.show(getSupportFragmentManager(), "deleteUser");
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(UserDetailActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
