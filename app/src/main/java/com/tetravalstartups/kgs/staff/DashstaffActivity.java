package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.client.DashclientActivity;

public class DashstaffActivity extends AppCompatActivity {

    private TextView tvAssignpayment, tvAssignfact;
    private ImageView ivnotifs, ivStafflogout;
    private CircleImageView ciStaffprof;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashstaff);

        tvAssignpayment = findViewById(R.id.tvAssignpayment);
        tvAssignfact = findViewById(R.id.tvAssignfact);
        ivnotifs = findViewById(R.id.ivnotifs);
        ivStafflogout = findViewById(R.id.ivStafflogout);
        ciStaffprof = findViewById(R.id.ciStaffprof);

            tvAssignpayment.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(DashstaffActivity.this, Staffassign_paymentsActivity.class));
                    finish();
                }
            });

            ivnotifs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(DashstaffActivity.this, StaffNotificationActivity.class));
                    finish();
                }
            });

            ciStaffprof.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(DashstaffActivity.this, StaffprofileActivity.class));
                    finish();
                }
            });

        tvAssignfact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashstaffActivity.this, AssignfactoryActivity.class));
                finish();
            }
        });

        ivStafflogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =  new AlertDialog.Builder(DashstaffActivity.this);
                builder.setTitle("LOGOUT");
                builder.setMessage("Are you sure you want to Logout?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


    }
}
