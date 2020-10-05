package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tetravalstartups.kgs.R;

public class Staff_EditprofileActivity extends AppCompatActivity {
    private TextView tvEdit_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff__editprofile);

        tvEdit_save = findViewById(R.id.tvEdit_save);

        tvEdit_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Staff_EditprofileActivity.this, "Saved Changes", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(Staff_EditprofileActivity.this, DashstaffActivity.class));
                finish();
            }
        });
    }
}