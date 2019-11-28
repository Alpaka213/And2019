package com.example.androidhw ;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    ImageView imageview;
    TextView username;
    TextView phone;
    TextView location;
    TextView email;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        imageview = (ImageView)findViewById(R.id.img1);
        username = (TextView)findViewById(R.id.username);
        phone = (TextView)findViewById(R.id.phone);
        location = (TextView)findViewById(R.id.location);
        email = (TextView)findViewById(R.id.email);

        Intent it= getIntent();

        int imageNumber = it.getIntExtra("image",0);

        if(imageNumber == 0) {
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.p1));
        }else if(imageNumber == 1)
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.p2));
        else if (imageNumber==2)
            imageview.setImageDrawable(getResources().getDrawable(R.drawable.p3));

        username.setText(it.getStringExtra("title"));
        phone.setText(it.getStringExtra("desc"));
        location.setText(it.getStringExtra("loc"));
        email.setText(it.getStringExtra("email"));
    }
}