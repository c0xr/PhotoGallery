package com.cory.photogallery;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView=findViewById(R.id.iv);

        new FetchTask().execute();
    }

    private class FetchTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try {
//                String result=new FlickrFetchr().getUrlString("https://www.baidu.com");
//                Log.i("tagg","fetched contents of url:"+result);

                byte[] bytes=new FlickrFetchr().getUrlBytes("");
                Bitmap bitmap=BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                mImageView.setImageBitmap(bitmap);
            }catch (IOException ioe){
                Log.i("tagg","failed to fetch url:",ioe);
            }
            return null;
        }
    }
}
