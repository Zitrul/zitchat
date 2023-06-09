package com.example.zitchat;

import static com.example.zitchat.MainActivity.REST;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zitchat.domain.Login;
import com.example.zitchat.rest.LoginApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    private EditText username_tv;
    private EditText password_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Intent intent = new Intent(this, MainActivity.class);
        password_tv = findViewById(R.id.editTextSecondName);
        username_tv = findViewById(R.id.editTextDesc);
        username_tv.getText().toString();
        password_tv.getText().toString();
        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginApiService.getInstance().getReg(username_tv.getText().toString(),password_tv.getText().toString(),"none","none","none").enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        Log.d(REST,response.body().toString());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        Log.d(REST,t.getMessage());
                    }
                });;

            }
        });
    }
}