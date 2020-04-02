package com.example.rxjavaandretrofit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;


import androidx.annotation.NonNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.LogRecord;

public class PictureLoader {
    /*
    * 数据解析类
    * */
    private static final String TAG = "jiazai";
    private ImageView loadimg;
    private String imgurl;
    private byte[]picbyte;
   Handler handler=new Handler(){
       @Override
       public void handleMessage(@NonNull Message msg) {
           super.handleMessage(msg);
           if (msg.what==0x123){
               Log.i(TAG, "已收到消息");
               if (picbyte!=null){
                   //将数据转化成为bitmap
                   Bitmap bitmap= BitmapFactory.decodeByteArray(picbyte,0,picbyte.length);
                   loadimg.setImageBitmap(bitmap);
                   //以位图的方式显示到imageview中
               }
           }
       }
   };
   //加载图片的方法
   public void load(ImageView loadimg,String imgurl){
       this.loadimg=loadimg;
       this.imgurl=imgurl;
       Drawable drawable=loadimg.getDrawable();
       if (drawable!=null && drawable instanceof BitmapDrawable){
           Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();
           if (bitmap!=null && !bitmap.isRecycled()){
               bitmap.recycle();
           }
           Log.i(TAG, "load: ");
       }
       //创建新线程
       new Thread(runnabe).start();
   }
    Runnable runnabe=new Runnable() {
        @Override
        public void run() {
            try {
                URL url=new URL(imgurl);
                HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setReadTimeout(10000);
                if (conn.getResponseCode()==200){//获取服务器返回代码200为成功
                    Log.i(TAG, "run: ");
                    InputStream in=conn.getInputStream();
                    ByteArrayOutputStream out=new ByteArrayOutputStream();
                    byte[]bytes=new byte[1024];
                    int length=1;
                    while ((length=in.read(bytes))!=-1){
                        out.write(bytes,0,length);
                    }
                    picbyte=out.toByteArray();
                    in.close();
                    out.close();
                    handler.sendEmptyMessage(0x123);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}
