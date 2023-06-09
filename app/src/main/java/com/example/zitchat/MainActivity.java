package com.example.zitchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zitchat.domain.Login;
import com.example.zitchat.rest.LoginApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String message = "";
    public static int auth_id = 0;
    public static final String REST = "REST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, RegistrationActivity.class);
        Intent intent1 = new Intent(this, MainPage.class);
        EditText name = findViewById(R.id.editTextDesc);
        EditText password = findViewById(R.id.editTextSecondName);
        Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = name.getText().toString() + "\n" + password.getText().toString();
                if (message != "") {
                    //sendMessage(message);
                    System.out.println(message);
                    LoginApiService.getInstance().getLogin(name.getText().toString(), password.getText().toString()).enqueue(new Callback<Login>() {
                        @Override
                        public void onResponse(Call<Login> call, Response<Login> response) {
                            Log.d(REST, response.body().toString());


                            try {
                                if (Integer.parseInt(response.body().getMsg()) >= 0) {


                                    auth_id = Integer.parseInt(response.body().getMsg());
                                    startActivity(intent1);
                                }

                            } catch (Exception i) {
                                SharedPreferences mSettings = getSharedPreferences("my_storage", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = mSettings.edit();
                                editor.putInt("is_logged", -1).apply();


                                System.out.println(i);
                            }
                        }

                        @Override
                        public void onFailure(Call<Login> call, Throwable t) {
                            Log.d(REST, t.getMessage());
                        }
                    });
                    ;

                }

            }
        });

        Button regme = findViewById(R.id.buttonreg);
        regme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent);
            }
        });


    }
}