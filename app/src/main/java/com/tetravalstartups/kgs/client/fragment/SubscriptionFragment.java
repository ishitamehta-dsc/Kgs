package com.tetravalstartups.kgs.client.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.ClientSubscriptionList;
import com.tetravalstartups.kgs.auth.view.AuthInterface;
import com.tetravalstartups.kgs.client.ClientSubscriptionAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubscriptionFragment extends Fragment {
    private View view;
    private int client_id;
    private SharedPreferences preferences;
    private static final String TAG = "SubscriptionFragment";
    private RecyclerView rvSubscription;
    private ClientSubscriptionAdapter clientSubscriptionAdapter;

    public SubscriptionFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_subscription, container, false);
        //Toast.makeText(getContext(), "bro iam here...", Toast.LENGTH_SHORT).show();
        initViews();
        return view;
    }

    private void initViews() {
        preferences = getContext().getSharedPreferences("login", 0);
        client_id = preferences.getInt("id", 0);
        rvSubscription = view.findViewById(R.id.rvSubscription);
        rvSubscription.setLayoutManager(new LinearLayoutManager(getContext()));
        
        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
        Call<ClientSubscriptionList> clientSubscriptionListCall = authInterface.clientSubscription(2);
        Log.e(TAG, "initViews: iam here bro....");
        clientSubscriptionListCall.enqueue(new Callback<ClientSubscriptionList>() {
            @Override
            public void onResponse(Call<ClientSubscriptionList> call, Response<ClientSubscriptionList> response) {
                Log.e(TAG, "onResponse: " + response.body() + response.message() + response.code());

                if (response.code() == 200) {
                    Log.e(TAG, "onResponse: " + response.code() + response.body().getData());
                    clientSubscriptionAdapter = new ClientSubscriptionAdapter(getContext(), response.body().getData());
                    clientSubscriptionAdapter.notifyDataSetChanged();
                    rvSubscription.setAdapter(clientSubscriptionAdapter);
                } else if (response.code() == 400) {
                    Toast.makeText(getContext(), "No Subscriptions to show", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Something went wrong, please contact administrator", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ClientSubscriptionList> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }
}