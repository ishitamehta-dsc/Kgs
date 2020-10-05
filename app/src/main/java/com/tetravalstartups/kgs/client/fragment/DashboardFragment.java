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
import android.widget.Toast;

import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.ClientDashboard;
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
        preferences = getContext().getSharedPreferences("login", 0);
        id = preferences.getInt("id",0);

        notificationRecyclerView = view.findViewById(R.id.notificationRecyclerView);
        notificationRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        notificationRecyclerView.setHasFixedSize(true);

        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
        Call<ClientDashboard> call = authInterface.clientDashboard(12);
        call.enqueue(new Callback<ClientDashboard>() {

            @Override
            public void onResponse(Call<ClientDashboard> call, Response<ClientDashboard> response) {
                Log.e(TAG, "onResponse: "+response.body().getData().getNotification());
                if (response.code() == 200) {

                    notificationDashboardAdapter = new NotificationDashboardAdapter(getContext(), response.body().getData().getNotification());
                    notificationDashboardAdapter.notifyDataSetChanged();
                    notificationRecyclerView.setAdapter(notificationDashboardAdapter);

                } else if (response.code() == 400){
                    Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ClientDashboard> call, Throwable t) {

            }
        });

    }
}
