package com.uc.hans_0706011910007;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.uc.hans_0706011910007.model.User;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<User> listUsers;
    CardView user_card;
//    private OnItemClickListener mOnItemClickListener;

//    public interface OnItemClickListener{
//        void OnItemClick(int position);
//    }

    public ArrayList<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(ArrayList<User> listUsers) {
        this.listUsers = listUsers;
//        this.mOnItemClickListener = onItemClickListener;
    }

    public MainAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MainAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
        return new MainAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CardViewViewHolder holder, final int position) {
        final User u = getListUsers().get(position);
        holder.fname.setText(u.getFname());
        holder.age.setText(u.getAge()+" Years Old");
        holder.address.setText(u.getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UserDetailActivity.class);
                intent.putExtra("listUsers", listUsers.get(position));
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListUsers().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        TextView fname, age, address;
        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            fname = itemView.findViewById(R.id.fname);
            age = itemView.findViewById(R.id.age);
            address = itemView.findViewById(R.id.address);
            user_card = itemView.findViewById(R.id.user_card);
//            itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            onItemClickListener.OnItemClick(getAdapterPosition());
//        }
    }
}
