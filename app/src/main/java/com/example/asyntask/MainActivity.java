package com.example.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static android.content.Context.POWER_SERVICE;

public class MainActivity extends AppCompatActivity {
    public static final String FILENAME="com.example.asyntask.FILENAME";
    public static final String URL="com.example.asyntask.URL";
    public ProgressDialog progressDialog;
    Button button,btnservice;
    ImageView imageView;
    TextView downloadStaus;
    public static String image_url = "https://image.shutterstock.com/image-photo/colorful-flower-on-dark-tropical-260nw-721703848.jpg";
    IntentFilter filter;
    public static final int REQUEST_CODE = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        btnservice=findViewById(R.id.btn_download);
        downloadStaus=findViewById(R.id.download_status);
        progressDialog = new ProgressDialog(this);
        imageView = findViewById(R.id.image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (internetConnectionCheck(MainActivity.this)) {
                    Toast.makeText(getApplicationContext(), "Internet Connection is available !!!",Toast.LENGTH_SHORT).show();
                    new Download().execute(image_url);
                } else

                {
                    Toast.makeText(getApplicationContext(), "No Internet Connection Try Later !", Toast.LENGTH_SHORT).show();
                }


            }
        });
        btnservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (internetConnectionCheck(MainActivity.this)) {
                    Toast.makeText(getApplicationContext(), "Internet Connection is available !!!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Myservice.class);
                    downloadStaus.setText("Service started");
                    startService(intent);
                } else

                {
                    Toast.makeText(getApplicationContext(), "No Internet Connection Try Later !", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String string = bundle.getString(Myservice.FILEPATH);
                Bitmap bitmap = BitmapFactory.decodeFile(string);
                imageView.setImageBitmap(bitmap);
                Log.v("path==", string + " ");
                int resultCode = bundle.getInt(Myservice.RESULT);
                if (resultCode == RESULT_OK) {
                    Toast.makeText(MainActivity.this,
                            "Download complete. Download URI: " + string,
                            Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(MainActivity.this, "Download failed",
                            Toast.LENGTH_LONG).show();

                }
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerBroadcast();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    //registering the broadcast
    private void registerBroadcast() {

        //broadcast name will be in MyService
        filter = new IntentFilter(Myservice.NOTIFICATION);
        registerReceiver(broadcastReceiver, filter);
    }

    public static boolean internetConnectionCheck(Activity CurrentActivity) {
        Boolean Connected = false;
        ConnectivityManager connectivity = (ConnectivityManager) CurrentActivity.getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) for (int i = 0; i < info.length; i++)
                if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                    Log.e("My Network is: ", "Connected ");
                    Connected = true;
                } else {}

        } else {
            Log.e("My Network is: ", "Not Connected");

            Toast.makeText(CurrentActivity.getApplicationContext(),
                    "Please Check Your internet connection",
                    Toast.LENGTH_LONG).show();
            Connected = false;

        }
        return Connected;

    }

    class Download extends AsyncTask<String,Integer, Bitmap> {

        @Override
        protected void onPreExecute() {
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("image downlaoder");
            progressDialog.setMessage("Downloading....");
            progressDialog.setIndeterminate(true);
            progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
            progressDialog.show();


        }

        @Override
        protected Bitmap doInBackground(String...params) {
            String url=params[0];
            Bitmap bm=null;
            try {
                InputStream is=new URL(url).openStream();

                bm= BitmapFactory.decodeStream(is);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bm;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values[0]);
            progressDialog.setIndeterminate(true);
            progressDialog.setMax(100);
            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
            progressDialog.dismiss();

        }
    }

}