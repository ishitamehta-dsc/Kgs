package com.tetravalstartups.kgs.client.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.tetravalstartups.kgs.auth.model.ClientFactoryList;
import com.tetravalstartups.kgs.auth.model.ClientMedia;
import com.tetravalstartups.kgs.auth.model.ClientProfileDetail;
import com.tetravalstartups.kgs.auth.view.AuthInterface;
import com.tetravalstartups.kgs.client.ClientFactoryAdapter;
import com.tetravalstartups.kgs.client.ClientMediaAdapter;

import org.w3c.dom.Text;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MediaFragment extends Fragment {
        private ClientMediaAdapter clientMediaAdapter;
        private RecyclerView rvMedia1;
        private SharedPreferences preferences;
        private View view;
        private int client_id;
        private static final String TAG = "MediaFragment";

    public MediaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view =  inflater.inflate(R.layout.fragment_media, container, false);
        initViews();
        return view;
    }

    private void initViews() {

        preferences = getContext().getSharedPreferences("login", 0);
        client_id = preferences.getInt("id", 0);
        rvMedia1 = view.findViewById(R.id.rvMedia1);
        rvMedia1.setLayoutManager(new LinearLayoutManager(getContext()));

        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
        // <--- TODO ----- change client id tp "client_id" after testing --->
        Call<List<ClientMedia>> clientMediaCall = authInterface.clientMedia(1);
        clientMediaCall.enqueue(new Callback<List<ClientMedia>>() {
            @Override
            public void onResponse(Call<List<ClientMedia>> call, Response<List<ClientMedia>> response) {
                Log.e(TAG, "onResponse: "+response.code()+response.message());
                for (int i = 0; i < response.body().size(); i++) {
                    ClientMedia clientMedia = response.body().get(i);
                    clientMediaAdapter = new ClientMediaAdapter(getContext(), clientMedia.getData());
                    clientMediaAdapter.notifyDataSetChanged();
                    rvMedia1.setAdapter(clientMediaAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<ClientMedia>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });

    }
}
