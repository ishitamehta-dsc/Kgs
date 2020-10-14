package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.view.AuthInterface;

public class Staff_EditprofileActivity extends AppCompatActivity {
    private TextView tvStaffSave;
    private TextView etStaffFName;
    private TextView etStaffLName;
    private TextView etStaffEditMob1;
    private TextView etStaffEditMob2;
    private TextView etStaffEditEmail;
    private TextView etStaffEditGender;
    private TextView etStaffEditDob;
    private TextView etStaffEditAddress;
    private TextView etStaffEditCity;
    private TextView etStaffEditState;
    private TextView etStaffEditPincode;
    private ImageView ivStaffEditBack;

    private SharedPreferences preferences;
    private static final String TAG = "Staff_EditProfile";
    int staff_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff__editprofile);
        preferences = this.getSharedPreferences("login", 0);
        staff_id = preferences.getInt("id", 0);
        tvStaffSave = findViewById(R.id.tvStaffSave);

        tvStaffSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);


            }
        });
    }
}