package com.uc.hans_0706011910007.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.uc.hans_0706011910007.AddUserActivity;
import com.uc.hans_0706011910007.MainActivity;
import com.uc.hans_0706011910007.R;
import com.uc.hans_0706011910007.model.SimpanData;
import com.uc.hans_0706011910007.model.User;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatDialogFragment {
    ArrayList<User>itemUsers;
    int pos;
    ProgressDialog progressDialog;
    public DeleteActivity(ArrayList<User> listUsers, int position) {
        itemUsers = listUsers;
        pos = position;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setMessage("Are you sure you want to delete " + itemUsers.get(pos).getFname() + "?")
                .setTitle("Alert")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        progressDialog = new ProgressDialog(getActivity());
                        progressDialog.show();
                        progressDialog.setContentView(R.layout.dialog_loading);
                        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        itemUsers.remove(pos);
                        intent.putExtra("listUsers", itemUsers);
                        intent.putExtra("position", pos);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        Toast.makeText(getActivity(), "Deleted Succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
        return builder.create();
    }
}
