package com.tetravalstartups.kgs.client.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.ClientDashboard;
import com.tetravalstartups.kgs.auth.model.ClientPayment;
import com.tetravalstartups.kgs.auth.view.AuthInterface;
import com.tetravalstartups.kgs.client.NotificationDashboardAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    private View view;
    private SharedPreferences preferences;
    private RecyclerView notificationRecyclerView;
    private TextView tvDashpendMoney;
    private TextView tvEmpty_view;
    private int id;
    private   NotificationDashboardAdapter notificationDashboardAdapter;
    private static final String TAG = "DashboardFragment";
    private List<ClientDashboard> clientDashboardList;
    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initView();
        return view;
    }

    private void initView() {

        tvDashpendMoney = view.findViewById(R.id.tvDashpendMoney);
        tvEmpty_view = view.findViewById(R.id.tvEmpty_view);

        preferences = getContext().getSharedPreferences("login", 0);
        id = preferences.getInt("id",0);

        //Toast.makeText(getContext(), ""+id, Toast.LENGTH_SHORT).show();

        notificationRecyclerView = view.findViewById(R.id.notificationRecyclerView);
        notificationRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        notificationRecyclerView.setHasFixedSize(true);



        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
        //<--- TODO: ----- change client id tp "client_id" after testing --->
        Call<ClientDashboard> call = authInterface.clientDashboard(1);
        call.enqueue(new Callback<ClientDashboard>() {
            @Override
            public void onResponse(Call<ClientDashboard> call, Response<ClientDashboard> response) {
                Log.e(TAG, "onResponse:"+response.code()+" "+response.message());
                if (response.code() == 200) {
                    notificationRecyclerView.setVisibility(View.VISIBLE);
                    tvEmpty_view.setVisibility(View.GONE);
                    notificationDashboardAdapter = new NotificationDashboardAdapter(getContext(), response.body().getData().getNotification());
                    notificationDashboardAdapter.notifyDataSetChanged();
                    notificationRecyclerView.setAdapter(notificationDashboardAdapter);
                } else if (response.code() == 400) {
                    Toast.makeText(getContext(), "No Notifications", Toast.LENGTH_SHORT).show();
                    notificationRecyclerView.setVisibility(View.GONE);
                    tvEmpty_view.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ClientDashboard> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });

        Call<ClientPayment> call1 = authInterface.clientPayment(1);
        call1.enqueue(new Callback<ClientPayment>() {
            @Override
            public void onResponse(Call<ClientPayment> call, Response<ClientPayment> response) {
                Log.e(TAG, "onResponse:"+response.code()+" "+response.message());
                if (response.code() == 200){
                    tvDashpendMoney.setText(response.body().getPendingAmount());
                }else if (response.code() == 400){
                    Toast.makeText(getContext(), "No Data", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "Something went wrong, contact to administrator", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ClientPayment> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });





    }
}
