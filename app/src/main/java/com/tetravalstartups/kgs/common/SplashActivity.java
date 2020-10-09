package com.tetravalstartups.kgs.common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.CheckUser;
import com.tetravalstartups.kgs.auth.view.AuthInterface;
import com.tetravalstartups.kgs.auth.view.LoginActivity;
import com.tetravalstartups.kgs.client.DashclientActivity;
import com.tetravalstartups.kgs.staff.DashstaffActivity;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        firebaseAuth = FirebaseAuth.getInstance();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (firebaseAuth.getCurrentUser() == null) {
                        //TODO: change dash client activity to login activity
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        String phone = firebaseAuth.getCurrentUser().getPhoneNumber();
                        phone.replace("+91", "");
                        checkUser(phone);
                    }
                }
            },2000);
        }


        private void checkUser(String number) {
            AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
            Call<CheckUser> call = authInterface.checkUser(number);
            call.enqueue(new Callback<CheckUser>() {
                @Override
                public void onResponse(Call<CheckUser> call, Response<CheckUser> response) {

                    if (response.code() == 200 ) {
                        CheckUser checkUser = response.body();

                        if (response.body().getType() == 1) {

                            SharedPreferences preferences = getSharedPreferences("login", 0);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putInt("id", checkUser.getData().getId());
                            editor.apply();
                            startActivity(new Intent(SplashActivity.this, DashclientActivity.class));
                            finish();

                        } else if (response.body().getType() == 2 ) {
                            startActivity(new Intent(SplashActivity.this, DashstaffActivity.class));
                            finish();
                        }
                    } else if (response.code() == 400) {
                        firebaseAuth.signOut();
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }

                @Override
                public void onFailure(Call<CheckUser> call, Throwable t) {

                }
            });
    }
}
