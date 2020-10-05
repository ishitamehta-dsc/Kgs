package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tetravalstartups.kgs.R;

public class VideoPhotoActivity extends AppCompatActivity {

    private ImageView ivVideoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_photo);

        ivVideoback = findViewById(R.id.ivVideoback);

        ivVideoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VideoPhotoActivity.this, AssignfactoryActivity.class));
                finish();
            }
        });
    }
}