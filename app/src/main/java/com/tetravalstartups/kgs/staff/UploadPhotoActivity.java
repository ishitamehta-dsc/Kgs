package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tetravalstartups.kgs.R;

public class UploadPhotoActivity extends AppCompatActivity {
    private TextView tvSubmit_Upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);

        tvSubmit_Upload = findViewById(R.id.tvSubmit_Upload);

        tvSubmit_Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UploadPhotoActivity.this, "Your media is uploaded successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UploadPhotoActivity.this, VideoPhotoActivity.class));
                finish();
            }
        });
    }
}