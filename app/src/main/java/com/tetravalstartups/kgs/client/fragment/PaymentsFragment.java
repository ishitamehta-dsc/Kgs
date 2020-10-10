package com.tetravalstartups.kgs.client.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
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
import com.tetravalstartups.kgs.auth.model.ClientPayment;
import com.tetravalstartups.kgs.auth.view.AuthInterface;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentsFragment extends Fragment {

    private TextView tvPending_Money;
    private TextView tvPaid_Money;

    private SharedPreferences preferences;
    private View view;
    private int client_id;

    private List<ClientPayment> clientPayments;

    private static final String TAG = "PaymentFragment";

    public PaymentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_payments, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        tvPending_Money = view.findViewById(R.id.tvPending_Money);
        tvPaid_Money = view.findViewById(R.id.tvPaid_Money);

        preferences = getContext().getSharedPreferences("login", 0);
        client_id = preferences.getInt("id", 0);

        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
        // TODO: ----- Change client id to "client_id" after testing
        Call<ClientPayment> clientPaymentCall = authInterface.clientPayment(2);
        clientPaymentCall.enqueue(new Callback<ClientPayment>() {
            @Override
            public void onResponse(Call<ClientPayment> call, Response<ClientPayment> response) {
                Log.e(TAG, "onResponse: " + response.body() + response.message() + response.code());
                if (response.code() == 200){
                    tvPending_Money.setText(response.body().getPendingAmount());
                    tvPaid_Money.setText(response.body().getPaidAmount());
                }else if (response.code() == 400){
                    Toast.makeText(getContext(), "No Data", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "Something went wrong, please contact Administrator", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ClientPayment> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
