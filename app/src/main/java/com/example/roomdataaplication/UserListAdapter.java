package com.example.roomdataaplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {
    Context context;
    ArrayList<Expence> userList;

    public UserListAdapter(Context context, ArrayList<Expence> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.user_list_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.MyViewHolder holder, int position) {

        Uri imgUri = Uri.parse(userList.get(position).getImageUrl());
        System.out.println("GetUserImageurl:  "+imgUri);
        Picasso.with(context).load(imgUri).into(holder.user_img);
        holder.tv_userName.setText(userList.get(position).getName());
        holder.tv_userCourse.setText(userList.get(position).getCoarseName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView user_img;
        TextView tv_userName,tv_userCourse;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            user_img = itemView.findViewById(R.id.user_img);
            tv_userName = itemView.findViewById(R.id.user_name);
            tv_userCourse = itemView.findViewById(R.id.user_coursename);
        }
    }
}
