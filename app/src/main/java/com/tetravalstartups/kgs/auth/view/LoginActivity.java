package com.tetravalstartups.kgs.auth.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.CheckUser;
import com.tetravalstartups.kgs.common.SplashActivity;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    private EditText etMobile;
    private TextView tvCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        etMobile = findViewById(R.id.etMobile);
        tvCont = findViewById(R.id.tvCont);

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

            }
        });

    }

    private void sendUserOtpScreen(String mobile) {
        Intent intent = new Intent(LoginActivity.this, OtpActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("phone", mobile);
        startActivity(intent);
        //finish();
    }

}

