package com.tetravalstartups.kgs.staff;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.StaffDashboard;
import com.tetravalstartups.kgs.auth.view.AuthInterface;
import com.tetravalstartups.kgs.client.DashclientActivity;

public class DashstaffActivity extends AppCompatActivity {

    private TextView tvAssignpayment, tvAssignfact;
    private TextView tvCompno1;
    private TextView tvCompno2;
    private TextView tvPendno1;
    private TextView tvPendno2;
    private ImageView ivnotifs, ivStafflogout;
    private CircleImageView ciStaffprof;
    private int staff_id;
    private SharedPreferences preferences;
    private static final String TAG = "DashstaffActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashstaff);
        init();
    }

    private void init() {

        tvAssignpayment = findViewById(R.id.tvAssignpayment);
        tvAssignfact = findViewById(R.id.tvAssignfact);
        tvCompno1 = findViewById(R.id.tvCompno1);
        tvCompno2 = findViewById(R.id.tvCompno2);
        tvPendno1 = findViewById(R.id.tvPendno1);
        tvPendno2 = findViewById(R.id.tvPendno2);
        ivnotifs = findViewById(R.id.ivnotifs);
        ivStafflogout = findViewById(R.id.ivStafflogout);
        ciStaffprof = findViewById(R.id.ciStaffprof);

        preferences = this.getSharedPreferences("login", 0);
        staff_id = preferences.getInt("id", 0);

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

        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
        // TODO: change ids after testing
        Call<StaffDashboard> call = authInterface.staffDashboard(1);
        call.enqueue(new Callback<StaffDashboard>() {
            @Override
            public void onResponse(Call<StaffDashboard> call, Response<StaffDashboard> response) {
                Log.e(TAG, "onResponse:"+response.code()+" "+response.message());
                if (response.code() == 200){
                    tvCompno1.setText(response.body().getData().getCompltedTaskShift1());
                    tvCompno2.setText(response.body().getData().getCompltedTaskShift2());
                    tvPendno1.setText(response.body().getData().getPendingTaskShift1());
                    tvPendno2.setText(response.body().getData().getPendingTaskShift2());
                }else if (response.code() == 400){
                    Toast.makeText(DashstaffActivity.this, "No Data", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DashstaffActivity.this, "Something went wrong, contact to administrator", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<StaffDashboard> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

    }
}
