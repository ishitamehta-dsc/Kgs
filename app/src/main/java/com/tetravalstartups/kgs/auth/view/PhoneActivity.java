package com.tetravalstartups.kgs.auth.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.client.DashclientActivity;
import com.tetravalstartups.kgs.staff.DashstaffActivity;

public class PhoneActivity extends AppCompatActivity {
    private Button btnStaff, btnClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        init();
    }

    private void init() {
        btnStaff = findViewById(R.id.btnStaff);
        btnClient = findViewById(R.id.btnClient);
            btnStaff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(PhoneActivity.this, DashstaffActivity.class));
                }
            });

            btnClient.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(PhoneActivity.this, DashclientActivity.class));
                }
            });
    }

}
