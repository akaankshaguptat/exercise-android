package com.example.asyntask;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

class Myservice extends IntentService{
    public static final String NOTIFICATION ="com.example.AsynTask.Myservice" ;
    public static final String FILEPATH ="filepath" ;
    public static final String RESULT = "result";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public Myservice(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        File file=new File(Environment.getExternalStorageDirectory(),"food.jpg");

        boolean success = file.mkdir();
        if (!success)
        {
            Log.v("directory not created", "directory not created");
        }
        Bitmap bitmap=null;
        try
        {
            URL url = new URL(MainActivity.image_url);
            URLConnection conn = url.openConnection();

            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bitmap = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
//
            //saving the file
            File createFolder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"test");
            createFolder.mkdir();
            File saveImage = new File(createFolder,"food.jpg");
            try {
                OutputStream outputStream = new FileOutputStream(saveImage);
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
                outputStream.flush();
                outputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //   Toast.makeText(MyIntentService.this, "Downloading Completed", Toast.LENGTH_SHORT).show();
            broadCastResult(saveImage.getAbsolutePath(),-1);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    //broadcasting the image path and result
    private void broadCastResult(String outputPath, int result) {
        Log.v("path=",outputPath);
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(FILEPATH, outputPath);
        intent.putExtra(RESULT, result);
        getApplicationContext().sendBroadcast(intent);
    }
}