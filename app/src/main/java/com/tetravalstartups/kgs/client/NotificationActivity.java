package com.tetravalstartups.kgs.client;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.ClientNotification;
import com.tetravalstartups.kgs.auth.view.AuthInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends AppCompatActivity {
    private ImageView ivNback;
    private RecyclerView rvClientNotification;
    private int client_id;
    private SharedPreferences preferences;
    private static final String TAG = "NotificationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        initViews();

    }

    private void initViews() {
        ivNback = findViewById(R.id.ivNback);
        preferences = this.getSharedPreferences("login", 0);
        client_id = preferences.getInt("id", 0);
        rvClientNotification = findViewById(R.id.rvClientNotification);
        rvClientNotification.setLayoutManager(new LinearLayoutManager(this));
        ivNback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NotificationActivity.this, DashclientActivity.class));

            }
        });
        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
        // <--- TODO ----- change client id tp "client_id" after testing --->

        Call<ClientNotification> call = authInterface.clientNotification(client_id);
        call.enqueue(new Callback<ClientNotification>() {
            @Override
            public void onResponse(Call<ClientNotification> call, Response<ClientNotification> response) {
                Log.e(TAG, "onResponse: " + response.code() + response.body() + response.message());

                if (response.code() == 200) {
                    Log.e(TAG, "onResponse: " + response.code() + response.body().getData().getNotification());
                    Toast.makeText(NotificationActivity.this, "You Have Notification", Toast.LENGTH_SHORT).show();
                    ClientNotificationAdapter clientNotificationAdapter = new ClientNotificationAdapter
                            (NotificationActivity.this, response.body().getData().getNotification());
                    clientNotificationAdapter.notifyDataSetChanged();
                    rvClientNotification.setAdapter(clientNotificationAdapter);
                } else if (response.code() == 400){
                    Toast.makeText(NotificationActivity.this, "You don't have any notification", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(NotificationActivity.this, "Something went wrong, contact to administration", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ClientNotification> call, Throwable t) {
                Toast.makeText(NotificationActivity.this, ""+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
