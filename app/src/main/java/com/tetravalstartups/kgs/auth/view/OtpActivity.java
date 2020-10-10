package com.tetravalstartups.kgs.auth.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.tetravalstartups.kgs.client.DashclientActivity;
import com.tetravalstartups.kgs.common.SplashActivity;
import com.tetravalstartups.kgs.staff.DashstaffActivity;

import java.util.concurrent.TimeUnit;

public class OtpActivity extends AppCompatActivity {

    private EditText etEnterotp;
    private TextView tvOtp, tvLog, tvOtplogin, tvResend;
    private FirebaseAuth firebaseAuth;
    private final static String country = "+91";
    private String phone;
    private LinearLayout lvCode;
    private ProgressBar pbOtp_bar;

    private String phoneVerificationId;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            verificationCallbacks;
    private PhoneAuthProvider.ForceResendingToken resendToken;

    private static final String TAG = "OtpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        init();

    }

    private void init() {
        firebaseAuth = FirebaseAuth.getInstance();

        etEnterotp = findViewById(R.id.etEnterotp);

        pbOtp_bar= findViewById(R.id.pbOtp_bar);

        tvOtp = findViewById(R.id.tvOtp);
        tvLog = findViewById(R.id.tvLog);
        tvOtplogin = findViewById(R.id.tvOtplogin);
        tvResend = findViewById(R.id.tvResend);

        lvCode = findViewById(R.id.lvCode);

        tvLog.setText(String.format("Please enter code the received on phone number %s",
                getIntent().getStringExtra("phone")));

        phone = getIntent().getStringExtra("phone");


        tvResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resendCode();
            }
        });


        tvOtplogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             doVerifyCode();
            }
        });

        sendCode();

    }

    private void sendCode() {
        setUpVerificationCallbacks();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                country+phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                verificationCallbacks);
    }

    private void setUpVerificationCallbacks() {
        verificationCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    Snackbar.make(lvCode, "Invalid Credentials", Snackbar.LENGTH_SHORT).show();
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    Snackbar.make(lvCode, "Limit Reached Try Again In a few Hours", Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                phoneVerificationId = s;
                resendToken = forceResendingToken;
            }

            @Override
            public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                super.onCodeAutoRetrievalTimeOut(s);
            }
        };
    }

    private void resendCode() {
        setUpVerificationCallbacks();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                country+phone,
                60,
                TimeUnit.SECONDS,
                this,
                verificationCallbacks,
                resendToken);
    }


    private void doVerifyCode() {
        String otp = etEnterotp.getText().toString();
        if (TextUtils.isEmpty(otp) || !TextUtils.isDigitsOnly(otp) || otp.length() != 6) {
            Toast.makeText(OtpActivity.this, "Please enter valid OTP.", Toast.LENGTH_LONG).show();
            return;
        }

        PhoneAuthCredential credential =
                PhoneAuthProvider.getCredential(phoneVerificationId, otp);
        signInWithPhoneAuthCredential(credential);

    }

    private void signInWithPhoneAuthCredential(final PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Snackbar.make(lvCode, "Successful", Snackbar.LENGTH_LONG).show();
                            String cred = task.getResult().getUser().getPhoneNumber();
                            cred.replace("+91", "");
                            checkUser();
                        } else {
                            if (task.getException() instanceof
                                    FirebaseAuthInvalidCredentialsException) {
                                Snackbar.make(lvCode, "Invalid Credentials", Snackbar.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }


    private void checkUser() {
        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);

        // <--- TODO ----- change client id tp "client_id" after testing --->
        Call<CheckUser> call = authInterface.checkUser("1212457896");
        call.enqueue(new Callback<CheckUser>() {
            @Override
            public void onResponse(Call<CheckUser> call, Response<CheckUser> response) {
                Log.e(TAG, "onResponse: "+response.code()+response.message() );
                if (response.code() == 200) {
                    CheckUser checkUser = response.body();
                    if (response.body().getType() == 1) {
                        SharedPreferences preferences = getSharedPreferences("login", 0);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("id", checkUser.getData().getId());
                        editor.apply();
                        Intent intent = new Intent(OtpActivity.this, DashclientActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(new Intent(intent));
                        finish();

                    } else if (response.body().getType() == 2) {
                        Intent intent = new Intent(OtpActivity.this, DashstaffActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(new Intent(intent));
                        finish();


                    }
                } else if (response.code() == 400) {
                    Toast.makeText(OtpActivity.this, "User does not exist please contact admin.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(OtpActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    finish();
                }

            }

            @Override
            public void onFailure(Call<CheckUser> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }


}
