package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;
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
        private CircleImageView cvStaffUserImg;
        private TextView tvStaffEdit;
        private TextView tvStaffName;
        private TextView tvStaffMob1;
        private TextView tvStaffMob2;
        private TextView tvStaffEmail;
        private TextView tvStaffGender;
        private TextView tvStaffDob;
        private TextView tvStaffAddress;
        private TextView tvStaffCity;
        private TextView tvStaffState;
        private TextView tvStaffPincode;

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
        tvStaffEdit = findViewById(R.id.tvStaffEdit);
        cvStaffUserImg = findViewById(R.id.cvStaffUserImg);
        tvStaffName = findViewById(R.id.tvStaffName);
        tvStaffMob1 = findViewById(R.id.tvStaffMob1);
        tvStaffMob2 = findViewById(R.id.tvStaffMob2);
        tvStaffEmail = findViewById(R.id.tvStaffEmail);
        tvStaffGender = findViewById(R.id.tvStaffGender);
        tvStaffDob = findViewById(R.id.tvStaffDob);
        tvStaffAddress = findViewById(R.id.tvStaffAddress);
        tvStaffCity = findViewById(R.id.tvStaffCity);
        tvStaffState = findViewById(R.id.tvStaffState);
        tvStaffPincode = findViewById(R.id.tvStaffPincode);

        preferences = this.getSharedPreferences("login", 0);
        staff_id = preferences.getInt("id", 0);

        ivProfileback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StaffprofileActivity.this, DashstaffActivity.class));

            }
        });

        tvStaffEdit.setOnClickListener(new View.OnClickListener() {
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
                    tvStaffName.setText(response.body().getData().getFname());
                    tvStaffMob1.setText(response.body().getData().getMobile1());
                    tvStaffMob2.setText(response.body().getData().getMobile2());
                    tvStaffEmail.setText(response.body().getData().getEmail());
                    tvStaffGender.setText(""+response.body().getData().getGender());
                    tvStaffDob.setText(response.body().getData().getDob());
                    tvStaffAddress.setText(response.body().getData().getAddress());
                    tvStaffCity.setText(response.body().getData().getCity());
                    tvStaffState.setText(response.body().getData().getState());
                    tvStaffPincode.setText(response.body().getData().getPincode());

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
