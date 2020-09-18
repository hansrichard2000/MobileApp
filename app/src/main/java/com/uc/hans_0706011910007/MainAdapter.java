package com.uc.hans_0706011910007;

import android.content.Context;
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
    private OnItemClickListener mOnItemClickListener;
    CardView cardView;

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public ArrayList<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(ArrayList<User> listUsers, OnItemClickListener onItemClickListener) {
        this.listUsers = listUsers;
        this.mOnItemClickListener = onItemClickListener;
    }

    public MainAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MainAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card, parent, false);
        return new MainAdapter.CardViewViewHolder(view, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CardViewViewHolder holder, int position) {
        final User u = getListUsers().get(position);
        holder.fname.setText(u.getFname());
        holder.age.setText(u.getAge()+" Years Old");
        holder.address.setText(u.getAddress());

    }

    @Override
    public int getItemCount() {
        return getListUsers().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView fname, age, address;
        OnItemClickListener onItemClickListener;
        public CardViewViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            fname = itemView.findViewById(R.id.fname);
            age = itemView.findViewById(R.id.age);
            address = itemView.findViewById(R.id.address);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.OnItemClick(getAdapterPosition());
        }
    }
}
