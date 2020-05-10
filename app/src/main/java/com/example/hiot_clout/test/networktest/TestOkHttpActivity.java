package com.example.hiot_clout.test.networktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hiot_clout.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * okhttp框架测试类
 */
public class TestOkHttpActivity extends AppCompatActivity {
//    tamy
//    2431492068@qq.com
//    abc123

//    private static final String baseUrl="http://61.135.169.125/";
    private static final String baseUrl="http://114.67.88.191:8080/";
    private static final String TAG = "TestOkHttpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_ok_http);

        Button btnExecute=findViewById(R.id.btn_okhttp_execute);
        btnExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testExecute();
            }
        });

        Button btnEnqueue=findViewById(R.id.btn_okhttp_enqueue);
        btnEnqueue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testEnqueue();
            }
        });

        Button btnLogin=findViewById(R.id.btn_okhttp_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login("tamy","abc123","app");
            }
        });

        Button btnUserinfo=findViewById(R.id.btn_okhttp_userinfo);
        btnUserinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserinfo("27bb6c07007e4f178f85c8db1f9152f4_d801298870a24a59ae1a7c7f738fd703_use");
            }
        });

        Button btnUpdateEmail=findViewById(R.id.btn_okhttp_update_email);
        btnUpdateEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEmail("27bb6c07007e4f178f85c8db1f9152f4_d801298870a24a59ae1a7c7f738fd703_use","2431492068@qq.com");
            }
        });
    }


    private void updateEmail(String authorization, String email) {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody body=new FormBody.Builder().build();
        String url=baseUrl+"user/email?email="+email;
        Request request=new Request.Builder().put(body).url(url).header("Authorization",authorization).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, "onFailure: "+e.getMessage(), e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d(TAG, "onResponse: "+response.body().string());
            }
        });
    }


    private void getUserinfo(String authorization) {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody body=new FormBody.Builder().build();
        String url=baseUrl+"user/one";
        Request request=new Request.Builder().get().url(url).header("Authorization",authorization).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, "onFailure: "+e.getMessage(), e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d(TAG, "onResponse: "+response.body().string());
            }
        });
    }


    /**
     * 登录
     * @param username
     * @param password
     * @param loginCode
     */
    private void login(String username,String password,String loginCode) {
        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody body=new FormBody.Builder().build();
        String url=baseUrl+String.format("auth/login?username=%s&password=%s&loginCode=%s",username,password,loginCode);
        Request request=new Request.Builder().post(body).url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, "onFailure: "+e.getMessage(), e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d(TAG, "onResponse: "+response.body().string());
            }
        });
    }


    private void testEnqueue() {
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(baseUrl).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, "onFailure: "+e.getMessage(), e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d(TAG, "onResponse: "+response.body().string());
            }
        });
    }

    private void testExecute() {

        new Thread(){
            @Override
            public void run() {
                OkHttpClient okHttpClient=new OkHttpClient();
                Request request=new Request.Builder().url(baseUrl).build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    Log.d(TAG, "run: "+response.body().string());
                } catch (IOException e) {
                    Log.e(TAG, "testExecute: "+ e.getMessage(),e );
                }
            }
        }.start();


    }


}
