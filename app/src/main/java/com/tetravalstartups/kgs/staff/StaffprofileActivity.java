package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.ClientProfileDetail;
import com.tetravalstartups.kgs.auth.model.StaffProfileDetail;
import com.tetravalstartups.kgs.auth.view.AuthInterface;

import java.util.List;
import java.util.Objects;

public class StaffprofileActivity extends AppCompatActivity {

        private ImageView ivProfileback;
        private TextView tvStaffedit;
        private TextView tvStaff_profilename;
        private TextView tvStaff_profilenumber;
        private TextView tvStaff_profileemail;
        private TextView tvStaffprofadd;
        private SharedPreferences preferences;
        private int staff_id;
    private static final String TAG = "StaffProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffprofile);

        initViews();
    }

    private void initViews() {

        ivProfileback = findViewById(R.id.ivProfileback);
        tvStaffedit = findViewById(R.id.tvStaffedit);
        tvStaff_profilename = findViewById(R.id.tvStaff_profilename);
        tvStaff_profilenumber = findViewById(R.id.tvStaff_profilenumber);
        tvStaff_profileemail = findViewById(R.id.tvStaff_profileemail);
        tvStaffprofadd = findViewById(R.id.tvStaffprofadd);
        tvStaffedit = findViewById(R.id.tvStaffedit);

        preferences = this.getSharedPreferences("login", 0);
        staff_id = preferences.getInt("id", 0);

        ivProfileback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StaffprofileActivity.this, DashstaffActivity.class));

            }
        });

        tvStaffedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StaffprofileActivity.this, Staff_EditprofileActivity.class));

            }
        });

        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
        Call<StaffProfileDetail> staffProfileDetailCall = authInterface.staffProfileDetail(staff_id);
        staffProfileDetailCall.enqueue(new Callback<StaffProfileDetail>() {
            @Override
            public void onResponse(Call<StaffProfileDetail> call, Response<StaffProfileDetail> response) {
                if (response.code() == 200) {
                    tvStaff_profilename.setText(response.body().getData().getFname());
                    tvStaff_profilenumber.setText(response.body().getData().getMobile1());
                    tvStaff_profileemail.setText(response.body().getData().getEmail());
                    tvStaffprofadd.setText(response.body().getData().getAddress());
                } else if (response.code() == 400){
                    Toast.makeText(StaffprofileActivity.this, "No Data", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(StaffprofileActivity.this, "Something went wrong, contact to administrator", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<StaffProfileDetail> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });
    }
}
