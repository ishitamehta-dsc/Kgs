package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.StaffNotification;
import com.tetravalstartups.kgs.auth.view.AuthInterface;
import com.tetravalstartups.kgs.client.NotificationActivity;

public class StaffNotificationActivity extends AppCompatActivity {
    private ImageView ivStaff_back;
    private RecyclerView staffNotificationRecyler;
    private int staff_id;
    private SharedPreferences preferences;
    private static final String TAG = "StaffNotificationAct";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_notification);

        initViews();
    }

    private void initViews() {
        ivStaff_back = findViewById(R.id.ivStaff_back);
        staffNotificationRecyler = findViewById(R.id.staffNotificationRecyler);
        staffNotificationRecyler.setLayoutManager(new LinearLayoutManager(this));

        preferences = this.getSharedPreferences("login", 0);
        staff_id = preferences.getInt("id", 0);

        ivStaff_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StaffNotificationActivity.this, DashstaffActivity.class));

            }
        });

        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
        // <--- TODO ----- change client id to "staff_id" after testing --->
        Call<StaffNotification> call = authInterface.staffNotification(1);
        call.enqueue(new Callback<StaffNotification>() {
            @Override
            public void onResponse(Call<StaffNotification> call, Response<StaffNotification> response) {
                Log.e(TAG, "onResponse: " + response.code() + response.body() + response.message());

                if (response.code() == 200){
                    Log.e(TAG, "onResponse: " + response.code() + response.body().getMessage());
                    Toast.makeText(StaffNotificationActivity.this, "You Have Notification", Toast.LENGTH_SHORT).show();
                    StaffNotificationAdapter staffNotificationAdapter = new StaffNotificationAdapter(StaffNotificationActivity.this, response.body().getMessage());
                    staffNotificationAdapter.notifyDataSetChanged();
                    staffNotificationRecyler.setAdapter(staffNotificationAdapter);
                }else if (response.code() == 400){
                    Toast.makeText(StaffNotificationActivity.this, "You don't have any notification", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(StaffNotificationActivity.this, "Something went wrong, contact to administration", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<StaffNotification> call, Throwable t) {
                Toast.makeText(StaffNotificationActivity.this, ""+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
