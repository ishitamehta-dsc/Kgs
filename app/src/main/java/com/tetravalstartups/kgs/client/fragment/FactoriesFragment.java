package com.tetravalstartups.kgs.client.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.ClientFactoryList;
import com.tetravalstartups.kgs.auth.view.AuthInterface;
import com.tetravalstartups.kgs.client.ClientFactoryAdapter;
import com.tetravalstartups.kgs.client.EditFactoryActivity;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FactoriesFragment extends Fragment {
    private View view;
    private ClientFactoryAdapter clientFactoryAdapter;
    private RecyclerView rvClientFactory;
    private SharedPreferences preferences;
    private TextView tvEdit1;
    private TextView tvDelete1;
    private static final String TAG = "FactoriesFragment";
    private int client_id;

    public FactoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_factories, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        preferences = getContext().getSharedPreferences("login", 0);
        client_id = preferences.getInt("id", 0);

        tvEdit1 = view.findViewById(R.id.tvEdit1);
        tvDelete1 = view.findViewById(R.id.tvDelete1);

        rvClientFactory = view.findViewById(R.id.rvClientFactory);
        rvClientFactory.setLayoutManager(new LinearLayoutManager(getContext()));


        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
        // <--- TODO ----- change client id tp "client_id" after testing --->
        Call<ClientFactoryList> clientFactoryListCall = authInterface.clientFactory(2);

        clientFactoryListCall.enqueue(new Callback<ClientFactoryList>() {
            @Override
            public void onResponse(Call<ClientFactoryList> call, Response<ClientFactoryList> response) {
                Log.e(TAG, "onResponse: " + response.body() + response.message());
                if (response.code() == 200) {
                    Log.e(TAG, "onResponse: " + response.code() + response.body().getData());
                    clientFactoryAdapter = new ClientFactoryAdapter(getContext(), response.body().getData());
                    clientFactoryAdapter.notifyDataSetChanged();
                    rvClientFactory.setAdapter(clientFactoryAdapter);
                } else if (response.code() == 400) {
                    Toast.makeText(getContext(), "No Factories to show", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Something went wrong, contact to administration", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ClientFactoryList> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
