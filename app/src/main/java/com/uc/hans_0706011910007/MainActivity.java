package com.uc.hans_0706011910007;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uc.hans_0706011910007.model.SimpanData;
import com.uc.hans_0706011910007.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecycleView;
    private long backPressedTime;
    private Toast backToast;
    FloatingActionButton button_add;
    TextView lbl_no_data;
    ArrayList<User> listUsers = SimpanData.listUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lbl_no_data = findViewById(R.id.textView);
        mRecycleView= findViewById(R.id.recyclerView);
        button_add = findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(intent);
                finish();
            }
        });
        if (listUsers.isEmpty()){
            lbl_no_data.setVisibility(View.VISIBLE);
        }
        else{
            lbl_no_data.setVisibility(View.INVISIBLE);
            showUsers(listUsers);
        }
    }

    private void showUsers(ArrayList<User> listUsers) {
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        MainAdapter adapter = new MainAdapter(MainActivity.this);
        adapter.setListUsers(listUsers);
        mRecycleView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed(){
        if (backPressedTime + 2000 > System.currentTimeMillis() ){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            backToast=Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}