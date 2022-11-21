package com.example.roomdataaplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Expence> userListModel = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        DataBaseHelper dataBaseHelper = DataBaseHelper.getDB(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userListModel = (ArrayList<Expence>) dataBaseHelper.expenceDao().getAllExpence();
        for (int i=0; i<userListModel.size(); i++){
            Log.d("UserListModel ","Name: "+userListModel.get(i).getName()+" Course: "+userListModel.get(i).getCoarseName()
                    +"  User Email: "+userListModel.get(i).getEmail()+"  Image:  "+userListModel.get(i).getImageUrl());
        }
        UserListAdapter adapter = new UserListAdapter(this,userListModel);
        recyclerView.setAdapter(adapter);
    }
}