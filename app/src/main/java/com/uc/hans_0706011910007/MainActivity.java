package com.uc.hans_0706011910007;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

    }
}