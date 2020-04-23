package com.example.intents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Explicit extends AppCompatActivity {
    TextView user_text,email_text,phone_text,pass_text;
    EditText url;
    Button browse,permissionBtn;
     final int CAMERA_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        Intent intent=getIntent();
        String user_name=intent.getStringExtra(MainActivity.EXTRA_USER);
        String email=intent.getStringExtra(MainActivity.EXTRA_EMAIL);
        int phone=intent.getIntExtra(MainActivity.EXTRA_PHONE,0);
        String pass=intent.getStringExtra(MainActivity.EXTRA_PASS);
        user_text=findViewById(R.id.textView3);
        email_text=findViewById(R.id.textView4);
        phone_text=findViewById(R.id.textView5);
        pass_text=findViewById(R.id.textView6);
        url=findViewById(R.id.editText2);
        browse=findViewById(R.id.button);
        permissionBtn=findViewById(R.id.permissionbtn);

        user_text.setText(user_name);
        email_text.setText(email);
        phone_text.setText(""+phone);
        pass_text.setText(pass);

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String url1=  url.getText().toString();
              if(!url1.equals(""))
              {
                  Intent intent1=new Intent(Intent.ACTION_VIEW,Uri.parse(url1));
                  startActivity(intent1);
              }
              else
                  Toast.makeText(Explicit.this,"Please enter the url",Toast.LENGTH_LONG).show();
            }
        });
        permissionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissions();
            }
        });

    }

    public void permissions() {



        if (ContextCompat.checkSelfPermission(Explicit.this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Explicit.this,
                    new String[]{Manifest.permission.CAMERA}, CAMERA_CODE);
        }
        else {
            Toast.makeText(this, "Permissions granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==CAMERA_CODE){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }
}
