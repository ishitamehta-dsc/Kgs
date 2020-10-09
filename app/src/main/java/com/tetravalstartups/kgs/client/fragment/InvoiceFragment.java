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
import com.tetravalstartups.kgs.auth.model.ClientFactoryList;
import com.tetravalstartups.kgs.auth.model.ClientInvoiceList;
import com.tetravalstartups.kgs.auth.view.AuthInterface;
import com.tetravalstartups.kgs.client.ClientFactoryAdapter;
import com.tetravalstartups.kgs.client.model.ClientInvoiceAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InvoiceFragment extends Fragment {

    private View view;
    private ClientInvoiceAdapter clientInvoiceAdapter;
    private RecyclerView rvClientInvoice;
    private SharedPreferences preferences;
    private static final String TAG = "InvoiceFragment";
    private Integer client_id;

    public InvoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_invoice, container, false);
        //initViews();
        return view;
    }

    private void initViews() {

        preferences = getContext().getSharedPreferences("login", 0);
        client_id = preferences.getInt("id", 0);

        rvClientInvoice = view.findViewById(R.id.rvClientInvoice);
        rvClientInvoice.setLayoutManager(new LinearLayoutManager(getContext()));

        AuthInterface authInterface = ApiClient.getClient().create(AuthInterface.class);
        // <--- TODO ----- change client id tp "client_id" after testing --->
       final Call<ClientInvoiceList> clientInvoiceListCall = authInterface.clientInvoice(2);

       clientInvoiceListCall.enqueue(new Callback<ClientInvoiceList>() {
           @Override
           public void onResponse(Call<ClientInvoiceList> call, Response<ClientInvoiceList> response) {
               Log.e(TAG, "onResponse: " + response.body() + response.message());
               if (response.code() == 200){
                   Log.e(TAG, "onResponse: " + response.code() + response.body().getData());
                   clientInvoiceAdapter.notifyDataSetChanged();
                   rvClientInvoice.setAdapter(clientInvoiceAdapter);
               }else if (response.code() == 400){
                   Toast.makeText(getContext(), "No Invoice to show", Toast.LENGTH_SHORT).show();
               }else {
                   Toast.makeText(getContext(), "Something went wrong, contact to administration", Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onFailure(Call<ClientInvoiceList> call, Throwable t) {
               Log.e(TAG, "onFailure: " + t.getMessage());
           }
       });


    }
}
