package com.tetravalstartups.kgs.client;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.UpdateClientFactory;
import com.tetravalstartups.kgs.auth.view.AuthInterface;

public class EditFactoryActivity extends AppCompatActivity {
    private TextView btnUpdateFact;
    private SharedPreferences preferences;
    private static final String TAG = "EditFactoryActivity";
    int client_id;
    int factory_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_factory);
        init();
    }

    private void init() {
        preferences = this.getSharedPreferences("login", 0);
        client_id = preferences.getInt("id", 0);
        btnUpdateFact = findViewById(R.id.btnUpdateFact);

        btnUpdateFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
                Call<UpdateClientFactory> call = authInterface.clientUpdateFactory(2,2);
                call.enqueue(new Callback<UpdateClientFactory>() {
                    @Override
                    public void onResponse(Call<UpdateClientFactory> call, Response<UpdateClientFactory> response) {
                        Log.e(TAG, "onResponse: " + response.code() + response.body() + response.message());

                        if (response.code() == 200){
                            Toast.makeText(EditFactoryActivity.this, "Your Request has been submitted Successcfully\n Please wait until it gets approved by the Administrator ", Toast.LENGTH_LONG).show();
                        }else if (response.code() == 400){
                            Toast.makeText(EditFactoryActivity.this, "Please wait one request is already pending", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(EditFactoryActivity.this, "Something went wrong, please Contact to Administrator", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<UpdateClientFactory> call, Throwable t) {
                        Toast.makeText(EditFactoryActivity.this, ""+t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });



            }
        });
    }
}