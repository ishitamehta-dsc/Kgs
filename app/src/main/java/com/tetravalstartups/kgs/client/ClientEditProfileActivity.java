package com.tetravalstartups.kgs.client;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.EditClientProfile;
import com.tetravalstartups.kgs.auth.view.AuthInterface;

import org.w3c.dom.Text;

public class ClientEditProfileActivity extends AppCompatActivity {
    private TextView tvUpdateFact;
    private SharedPreferences preferences;
    private static final String TAG = "ClientEditProfileActivity";
    int client_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_edit_profile);
        init();
    }

    private void init() {
        preferences = this.getSharedPreferences("login", 0);
        client_id = preferences.getInt("id", 0);
        tvUpdateFact  = findViewById(R.id.tvUpdateFact);

        tvUpdateFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
                Call<EditClientProfile> clientProfileCall = authInterface.clientEditProfile(1);
                clientProfileCall.enqueue(new Callback<EditClientProfile>() {
                    @Override
                    public void onResponse(Call<EditClientProfile> call, Response<EditClientProfile> response) {
                        //Log.e(TAG, "onResponse: " + response.code() + response.body() + response.message());
                        if (response.code() == 200){
                            Toast.makeText(ClientEditProfileActivity.this, "Your Request has been submitted Successcfully\n Please wait until it gets approved by the Administrator", Toast.LENGTH_SHORT).show();
                        }else if (response.code() == 400){
                            Toast.makeText(ClientEditProfileActivity.this, "Please wait one request is already pending", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(ClientEditProfileActivity.this, "Something went wrong, please Contact to Administrator", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<EditClientProfile> call, Throwable t) {
                        Toast.makeText(ClientEditProfileActivity.this, ""+t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}