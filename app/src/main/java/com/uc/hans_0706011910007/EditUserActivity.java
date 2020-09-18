package com.uc.hans_0706011910007;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputLayout;

public class EditUserActivity extends AppCompatActivity implements TextWatcher {

    TextInputLayout user_nama, user_umur, user_alamat;
    Button button_tambah;
    String fname, age, address;
    Toolbar toolbar;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit User");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditUserActivity.this, UserDetailActivity.class);
                startActivity(intent);
                finish();
            }
        });
        user_nama = findViewById(R.id.user_nama);
        user_umur = findViewById(R.id.user_umur);
        user_alamat = findViewById(R.id.user_address);
        button_tambah = findViewById(R.id.button_tambah);
        user_nama.getEditText().toString().trim();
        user_nama.getEditText().addTextChangedListener(this);
        user_umur.getEditText().addTextChangedListener(this);
        user_alamat.getEditText().addTextChangedListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(EditUserActivity.this, UserDetailActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
