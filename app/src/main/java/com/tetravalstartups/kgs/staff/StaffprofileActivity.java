package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tetravalstartups.kgs.R;

public class StaffprofileActivity extends AppCompatActivity {

        private ImageView ivProfileback;
        private TextView tvStaffedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffprofile);

            ivProfileback = findViewById(R.id.ivProfileback);
            tvStaffedit = findViewById(R.id.tvStaffedit);

            ivProfileback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(StaffprofileActivity.this, DashstaffActivity.class));
                    finish();
                }
            });

            tvStaffedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(StaffprofileActivity.this, Staff_EditprofileActivity.class));
                    finish();
                }
            });
    }
}
