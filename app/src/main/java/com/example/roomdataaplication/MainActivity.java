package com.example.roomdataaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_mobile,et_email,et_courseName;
    Button btn_save;
    private static final int PICK_IMAGE = 100;
    ImageView user_img;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_mobile = findViewById(R.id.et_mobile);
        TextView UserList = findViewById(R.id.UserList);
        UserList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UserListActivity.class);
                startActivity(intent);
            }
        });
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_Email);
        user_img = findViewById(R.id.st_profile_img);
        user_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        et_courseName = findViewById(R.id.et_course_name);
        btn_save = findViewById(R.id.btn_save);
        DataBaseHelper dataBaseHelper = DataBaseHelper.getDB(this);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString().trim();
                String mobile = et_mobile.getText().toString().trim();
                String email = et_email.getText().toString().trim();
                String course = et_courseName.getText().toString().trim();
                String imgUri = String.valueOf(imageUri);

                dataBaseHelper.expenceDao().insertData(new Expence(name,mobile,email,course,imgUri));

                Toast.makeText(MainActivity.this, "Data save into Database", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getApplicationContext(),UserListActivity.class);
//                startActivity(intent);
                ArrayList<Expence> arrExpence = (ArrayList<Expence>) dataBaseHelper.expenceDao().getAllExpence();
                for (int i=0; i<arrExpence.size(); i++){
                    Log.d("Data","Name: "+arrExpence.get(i).getName()+" Course: "+arrExpence.get(i).getCoarseName()
                    +"  User Email: "+arrExpence.get(i).getEmail()+"  Image:  "+arrExpence.get(i).getImageUrl());
                }
            }
        });
    }
    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            user_img.setImageURI(imageUri);
            System.out.println("ImagePath:  "+imageUri);

//            try {
//                imageProfilePath = Utils.getPath(imageUri, getApplicationContext());
////                System.out.println("ProfilepathImage   " + imageProfilePath);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            File file = new File(imageProfilePath);
//            RequestBody mFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//            multiImage = MultipartBody.Part.createFormData("profile_img", file.getName(), mFile);
//            RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());


        }
    }
}