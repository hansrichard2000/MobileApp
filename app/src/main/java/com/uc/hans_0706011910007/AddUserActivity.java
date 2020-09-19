package com.uc.hans_0706011910007;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;
import com.uc.hans_0706011910007.model.SimpanData;
import com.uc.hans_0706011910007.model.User;

import java.util.ArrayList;

import java.util.ArrayList;

public class AddUserActivity extends AppCompatActivity implements TextWatcher {

    TextInputLayout user_nama, user_umur, user_alamat;
    Button button_tambah;
    String fname, age, address;
    boolean update;
    Toolbar toolbar;
    boolean update;
    int position = 0;
    ArrayList<User> listUsers = SimpanData.listUsers;
    User user;
    ProgressDialog progressDialog;
    int position = 0;
    User user;
    ArrayList<User> listUsers = SimpanData.listUsers;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user_nama = findViewById(R.id.user_nama);
        user_umur = findViewById(R.id.user_umur);
        user_alamat = findViewById(R.id.user_address);
        button_tambah = findViewById(R.id.button_tambah);
        user_nama.getEditText().addTextChangedListener(this);
        user_umur.getEditText().addTextChangedListener(this);
        user_alamat.getEditText().addTextChangedListener(this);
        button_tambah.setText("Save Data");
        getSupportActionBar().setTitle("Add User");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddUserActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        button_tambah.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(AddUserActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.dialog_loading);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                User user = new User(fname, address, age);
                SimpanData.listUsers.add(user);
                Intent intent = new Intent(AddUserActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AddUserActivity.this);
                startActivity(intent, options.toBundle());
                finish();
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user == null){
                    Intent intent = new Intent(AddUserActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(AddUserActivity.this, UserDetailActivity.class);
                    intent.putExtra("listUsers", listUsers.get(pos));
                    intent.putExtra("position", pos);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        fname = user_nama.getEditText().getText().toString().trim();
        age = user_umur.getEditText().getText().toString().trim();
        address = user_alamat.getEditText().getText().toString().trim();

        if (!fname.isEmpty()&& !address.isEmpty() && !age.isEmpty()){
            button_tambah.setEnabled(true);
        }else {
            button_tambah.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(AddUserActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
