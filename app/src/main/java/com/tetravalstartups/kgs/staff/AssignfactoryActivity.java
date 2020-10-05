package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tetravalstartups.kgs.R;

public class AssignfactoryActivity extends AppCompatActivity {

    private ImageView ivFactoryback;
    private CardView cvFactdetail1, cvFactdetail2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignfactory);

        ivFactoryback = findViewById(R.id.ivFactoryback);
        cvFactdetail1 = findViewById(R.id.cvFactdetail1);
        cvFactdetail2 = findViewById(R.id.cvFactdetail2);


        ivFactoryback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AssignfactoryActivity.this, DashstaffActivity.class));
                finish();
            }
        });

        cvFactdetail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AssignfactoryActivity.this, UploadPhotoActivity.class));
                finish();
            }
        });

        cvFactdetail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AssignfactoryActivity.this, UploadPhotoActivity.class));
                finish();
            }
        });


    }
}
