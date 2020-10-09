package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tetravalstartups.kgs.R;

public class StaffNotificationActivity extends AppCompatActivity {
    private ImageView ivStaff_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_notification);

        ivStaff_back = findViewById(R.id.ivStaff_back);

        ivStaff_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StaffNotificationActivity.this, DashstaffActivity.class));

            }
        });
    }
}
