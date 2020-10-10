package com.tetravalstartups.kgs.client;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.CheckUser;
import com.tetravalstartups.kgs.auth.model.ClientDashboard;
import com.tetravalstartups.kgs.auth.model.ClientProfileDetail;
import com.tetravalstartups.kgs.auth.view.AuthInterface;
import com.tetravalstartups.kgs.auth.view.LoginActivity;
import com.tetravalstartups.kgs.client.fragment.DashboardFragment;
import com.tetravalstartups.kgs.client.fragment.FactoriesFragment;
import com.tetravalstartups.kgs.client.fragment.HelpFragment;
import com.tetravalstartups.kgs.client.fragment.InvoiceFragment;
import com.tetravalstartups.kgs.client.fragment.MediaFragment;
import com.tetravalstartups.kgs.client.fragment.PaymentsFragment;
import com.tetravalstartups.kgs.client.fragment.ProfileFragment;
import com.tetravalstartups.kgs.client.fragment.SubscriptionFragment;
import com.tetravalstartups.kgs.common.MainActivity;
import com.tetravalstartups.kgs.common.SplashActivity;

public class DashclientActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private ImageView ivmenunav, ivnotif;
    private CircleImageView cvUserPic;
    private TextView tvUserName;
    private TextView tvUserNo;
    private TextView tvToolbarTitle;
    private FrameLayout frameContent;
    private DrawerLayout drawerlayout;
    private NavigationView nav_view;
    private LinearLayout lhActionBarContent;
    private SharedPreferences preferences;
    private Integer client_id;
    private static final String TAG = "DashclientActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashclient);

        init();
    }

    private void init() {
        ivmenunav = findViewById(R.id.ivmenunav);
        ivnotif = findViewById(R.id.ivnotif);
        tvToolbarTitle = findViewById(R.id.tvToolbarTitle);
        frameContent = findViewById(R.id.frameContent);
        lhActionBarContent = findViewById(R.id.lhActionBarContent);
        drawerlayout = findViewById(R.id.drawerlayout);
        nav_view = findViewById(R.id.nav_view);

        cvUserPic = findViewById(R.id.cvUserPic);
        tvUserName = findViewById(R.id.tvUserName);
        tvUserName = findViewById(R.id.tvUserName);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameContent,
                new DashboardFragment()).commit();
        nav_view.setCheckedItem(R.id.dashboard);
        ivmenunav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerlayout.openDrawer(GravityCompat.START);
            }
        });

        ivnotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashclientActivity.this, NotificationActivity.class));
            }
        });
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContent,
                                new ProfileFragment()).addToBackStack(null).commit();
                        tvToolbarTitle.setText("Profile");
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.dashboard:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new DashboardFragment()).commit();
                        tvToolbarTitle.setText("Client Dashboard");
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.factories:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new FactoriesFragment()).commit();
                        tvToolbarTitle.setText("Factories");
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.payments:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new PaymentsFragment()).commit();
                        tvToolbarTitle.setText("Payments");
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.invoice:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new InvoiceFragment()).commit();
                        tvToolbarTitle.setText("Invoice");
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.subscriptions:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new SubscriptionFragment()).commit();
                        tvToolbarTitle.setText("Subscriptions");
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.media:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new MediaFragment()).commit();
                        tvToolbarTitle.setText("Media");
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.help:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new HelpFragment()).commit();
                        tvToolbarTitle.setText("Help");
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.policy:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new InvoiceFragment()).commit();
                        tvToolbarTitle.setText("Policies");
                        drawerlayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.logout:
                        AlertDialog.Builder builder =  new AlertDialog.Builder(DashclientActivity.this);
                        builder.setTitle("LOGOUT");
                        builder.setMessage("Are you sure you want to Logout?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                firebaseAuth.signOut();
                               Intent intent = new Intent(DashclientActivity.this, LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        AlertDialog alert1 = builder.create();
                        alert1.show();
                }
                return true;
            }
        });
//        preferences = getSharedPreferences("login", 0);
//        client_id = preferences.getInt("id", 0);
//
//        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
//        // TODO: ----- Change client id to "client_id" after testing
//        Call<ClientProfileDetail> clientProfileDetailCall = authInterface.clientProfileDetail(2);
//        clientProfileDetailCall.enqueue(new Callback<ClientProfileDetail>() {
//            @Override
//            public void onResponse(Call<ClientProfileDetail> call, Response<ClientProfileDetail> response) {
//                Log.e(TAG, "onResponse: " + response.body() + response.message() + response.code());
//                if (response.code() == 200){
//                    tvUserName.setText(response.body().getData().getFname());
//                    tvUserNo.setText(response.body().getData().getMobile1());
//                    //cvUserPic.setImageResource(response.body().getData().getProfileImage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ClientProfileDetail> call, Throwable t) {
//                Log.e(TAG, "onResponse: " + t.getMessage());
//            }
//        });

        //SharedPreferences preferences = getSharedPreferences("login", 0);
       // int id = preferences.getInt("id", 0);


    }

//    boolean doubleBackToExitPressedOnce = false;
//
//    @Override
//    public void onBackPressed() {
//        if (doubleBackToExitPressedOnce) {
//            super.onBackPressed();
//            return;
//        }
//
//        this.doubleBackToExitPressedOnce = true;
//        //Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
//
//
//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                doubleBackToExitPressedOnce=false;
//            }
//        }, 2000);
//    }



}


