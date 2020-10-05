package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tetravalstartups.kgs.R;

public class Staffassign_paymentsActivity extends AppCompatActivity {

        private ImageView ivAssignback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffassign_payments);


            ivAssignback = findViewById(R.id.ivAssignback);

            ivAssignback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Staffassign_paymentsActivity.this, DashstaffActivity.class));
                    finish();
                }
            });
    }
}
