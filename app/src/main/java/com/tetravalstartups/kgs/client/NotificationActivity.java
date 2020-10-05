package com.tetravalstartups.kgs.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tetravalstartups.kgs.R;

public class NotificationActivity extends AppCompatActivity {
    private ImageView ivNback;
    private RecyclerView rvClientNoti_recycler;
    String client_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ivNback = findViewById(R.id.ivNback);

        rvClientNoti_recycler = findViewById(R.id.rvClientNoti_recycler);

            ivNback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(NotificationActivity.this, DashclientActivity.class));
                    finish();
                }
            });
    }
}
