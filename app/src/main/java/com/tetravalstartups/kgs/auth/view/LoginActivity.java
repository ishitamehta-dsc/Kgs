package com.tetravalstartups.kgs.auth.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.CheckUser;
import com.tetravalstartups.kgs.common.SplashActivity;
import com.tetravalstartups.kgs.staff.DashstaffActivity;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    private EditText etMobile;
    private TextView tvCont;
    private final static String country = "+91";
    private FirebaseAuth firebaseAuth;
    private String phone;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        etMobile = findViewById(R.id.etMobile);
        tvCont = findViewById(R.id.tvCont);

        firebaseAuth = FirebaseAuth.getInstance();

        tvCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mobile = etMobile.getText().toString();

                if (TextUtils.isEmpty(mobile)) {
                    etMobile.setError("Enter Mobile Number");
                    return;
                }

                if (!TextUtils.isDigitsOnly(mobile)) {
                    etMobile.setError("Mobile number must be in digits");
                    return;
                }

                if (mobile.length() < 10 || mobile.length() > 10) {
                    etMobile.setError("Mobile Number must contain 10 digits");
                    return;
                }
                sendUserOtpScreen(mobile);
                //checkUser();

            }
        });

    }

//    private void checkUser() {
//
//        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
//        // <--- TODO ----- change id tp "phone" after testing --->
//        Call<CheckUser> call = authInterface.checkUser("8888888888");
//        call.enqueue(new Callback<CheckUser>() {
//            @Override
//            public void onResponse(Call<CheckUser> call, Response<CheckUser> response) {
//                Log.e(TAG, "onResponse: "+response.code()+response.message() );
//                if (response.code() == 200){
//                    if (response.body().getType() == 1){
//                    Toast.makeText(LoginActivity.this, "Successful as client", Toast.LENGTH_SHORT).show();
//                    SharedPreferences preferences = getSharedPreferences("login", 0);
//
//                    }
//                    else if (response.body().getType() == 2){
//                        Toast.makeText(LoginActivity.this, "successfull as staff", Toast.LENGTH_SHORT).show();
//                      Intent intent = new Intent(LoginActivity.this, OtpActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        startActivity(new Intent(intent));
//                        finish();
//                }
//                    Intent intent = new Intent(LoginActivity.this, OtpActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    intent.putExtra("phone", phone);
//                    startActivity(new Intent(intent));
//                    finish();
//
//                }else if (response.code() == 400){
//                    Toast.makeText(LoginActivity.this, "User does not exist please contact admin", Toast.LENGTH_LONG).show();
//                }
//            }

//            @Override
//            public void onFailure(Call<CheckUser> call, Throwable t) {
//                Log.e(TAG, "onFailure: "+t.getMessage());
//            }
//        });
//    }

    private void sendUserOtpScreen(String mobile) {
        Intent intent = new Intent(LoginActivity.this, OtpActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("phone", mobile);
        startActivity(intent);
        finish();
    }

}

