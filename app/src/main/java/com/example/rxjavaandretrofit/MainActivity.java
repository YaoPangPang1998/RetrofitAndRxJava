package com.example.rxjavaandretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "jiazai";
    private static final String BASE_URL = "http://gank.io/api/data/福利/";
    private ImageView imageView;
    private Button button;
    private ArrayList<String> urls;
    private int curPos=0;
    //图片加载器
    private PictureLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化图片加载器
        loader = new PictureLoader();
        //initData();
        //initUI();
        WebFactory webFactory=new WebFactory();
        webFactory.getRetrofitManager().get(BASE_URL, "10", 1, new callback() {
            @Override
            public void onRuccess(Sister sister) {
                TextView textView=findViewById(R.id.textView);
                textView.setText(sister.getResults().get(0).get_id().toString());
               // imageView.setTex

            }

            @Override
            public void fail(String errMSG) {

            }
        });
    }
    public void initData(){
        urls = new ArrayList<>();
        urls.add("http://ww4.sinaimg.cn/large/610dc034jw1f6ipaai7wgj20dw0kugp4.jpg");
        urls.add("http://ww3.sinaimg.cn/large/610dc034jw1f6gcxc1t7vj20hs0hsgo1.jpg");
        urls.add("http://ww4.sinaimg.cn/large/610dc034jw1f6f5ktcyk0j20u011hacg.jpg");
        urls.add("http://ww1.sinaimg.cn/large/610dc034jw1f6e1f1qmg3j20u00u0djp.jpg");
        urls.add("http://ww3.sinaimg.cn/large/610dc034jw1f6aipo68yvj20qo0qoaee.jpg");
        urls.add("http://ww3.sinaimg.cn/large/610dc034jw1f69c9e22xjj20u011hjuu.jpg");
        urls.add("http://ww3.sinaimg.cn/large/610dc034jw1f689lmaf7qj20u00u00v7.jpg");
        urls.add("http://ww3.sinaimg.cn/large/c85e4a5cjw1f671i8gt1rj20vy0vydsz.jpg");
        urls.add("http://ww2.sinaimg.cn/large/610dc034jw1f65f0oqodoj20qo0hntc9.jpg");
        urls.add("http://ww2.sinaimg.cn/large/c85e4a5cgw1f62hzfvzwwj20hs0qogpo.jpg");
        Log.i(TAG, " "+ urls.size());
    }
    public void initUI(){
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curPos>9){
                    curPos=0;
                }
                //loader.load(imageView,urls.get(curPos));
                loader.load(imageView, urls.get(curPos));
                curPos++;
            }
        });
    }


//    //网络请求方法
//    public void request(String number,int page){
//
//
//    }
}
