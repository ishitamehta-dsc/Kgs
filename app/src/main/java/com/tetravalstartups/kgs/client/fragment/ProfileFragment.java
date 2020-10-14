package com.tetravalstartups.kgs.client.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tetravalstartups.kgs.ApiClient;
import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.ClientProfileDetail;
import com.tetravalstartups.kgs.auth.view.AuthInterface;
import com.tetravalstartups.kgs.client.ClientEditProfileActivity;
import com.tetravalstartups.kgs.client.EditFactoryActivity;

import java.util.List;

import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private TextView tvNameValue;
    private TextView tvMobValue;
    private TextView tvAlt_MobValue;
    private TextView tvEmailValue;
    private TextView tvAlt_EmailValue;
    private TextView tvAddressValue;
    private TextView tvCompanyName_Value;
    private TextView tvGstNum_Value;
    private TextView tvEdit;
    private SharedPreferences preferences;
    private View view;
    private int client_id;
    private List<ClientProfileDetail> clientProfileDetails;
    private static final String TAG = "ProfileFragment";

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        tvNameValue = view.findViewById(R.id.tvNameValue);
        tvMobValue = view.findViewById(R.id.tvMobValue);
        tvAlt_MobValue = view.findViewById(R.id.tvAlt_MobValue);
        tvEmailValue = view.findViewById(R.id.tvEmailValue);
        tvAlt_EmailValue = view.findViewById(R.id.tvAlt_EmailValue);
        tvAddressValue = view.findViewById(R.id.tvAddressValue);
        tvCompanyName_Value = view.findViewById(R.id.tvCompanyName_Value);
        tvGstNum_Value = view.findViewById(R.id.tvGstNum_Value);
        tvEdit = view.findViewById(R.id.tvEdit);

        tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ClientEditProfileActivity.class);
                startActivity(intent);
            }
        });

        preferences = getContext().getSharedPreferences("login", 0);
        client_id = preferences.getInt("id", 0);

        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
        // TODO: ----- Change client id to "client_id" after testing
        Call<ClientProfileDetail> clientProfileDetailCall = authInterface.clientProfileDetail(client_id);
        clientProfileDetailCall.enqueue(new Callback<ClientProfileDetail>() {
            @Override
            public void onResponse(Call<ClientProfileDetail> call, Response<ClientProfileDetail> response) {
                Log.e(TAG, "onResponse: " + response.body() + response.message() + response.code());
                if (response.code() == 200) {
                    tvNameValue.setText(response.body().getData().getFname());
                    tvMobValue.setText(response.body().getData().getMobile1());
                    tvAlt_MobValue.setText(response.body().getData().getMobile2());
                    tvEmailValue.setText(response.body().getData().getEmail1());
                    tvAddressValue.setText(response.body().getData().getAddress());
                    tvAlt_EmailValue.setText(response.body().getData().getEmail2());
                    tvGstNum_Value.setText(response.body().getData().getGstNumber());
                    tvCompanyName_Value.setText(response.body().getData().getCompanyName());

                } else if (response.code() == 400) {
                    Toast.makeText(getContext(), "No Data", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Something went wrong, contact to administrator", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ClientProfileDetail> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

    }


}
