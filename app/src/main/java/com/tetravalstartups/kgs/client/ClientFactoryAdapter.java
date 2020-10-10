package com.tetravalstartups.kgs.client;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.ClientFactoryList;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClientFactoryAdapter extends RecyclerView.Adapter<ClientFactoryAdapter.ClientFactoryViewHolder> {

    private Context context;
    private List<ClientFactoryList.Datum> clientFactoryList;

    public ClientFactoryAdapter(Context context, List<ClientFactoryList.Datum> clientFactoryList) {
        this.context = context;
        this.clientFactoryList = clientFactoryList;
    }

    @NonNull
    @Override
    public ClientFactoryAdapter.ClientFactoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.factory_item, parent, false);
        return new ClientFactoryViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ClientFactoryAdapter.ClientFactoryViewHolder holder, final int position) {
        holder.tvFactoryName.setText(clientFactoryList.get(position).getLocationName());
        holder.tvFactoryAddress.setText(""+clientFactoryList.get(position).getAddress());
        holder.tvFactoryCity.setText(""+clientFactoryList.get(position).getCity());
        holder.tvFactoryState.setText(""+clientFactoryList.get(position).getState());
        holder.tvFactoryPin.setText(""+clientFactoryList.get(position).getPincode());
        holder.tvFactoryCountry.setText(""+clientFactoryList.get(position).getCountry());
        holder.tvCreatedDate.setText(""+clientFactoryList.get(position).getCreatedDate());

        holder.tvEdit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EditFactoryActivity.class);
                context.startActivity(intent);
            }
        });



        holder.tvDelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClientFactoryList.Datum theRemovedItem = clientFactoryList.get(position);
                clientFactoryList.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clientFactoryList.size();
    }

    public class ClientFactoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFactoryName;
        private TextView tvFactoryAddress;
        private TextView tvFactoryCity;
        private TextView tvFactoryState;
        private TextView tvFactoryPin;
        private TextView tvFactoryCountry;
        private TextView tvCreatedDate;
        private TextView tvEdit1;
        private TextView tvDelete1;
        public ClientFactoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFactoryName= itemView.findViewById(R.id.tvFactoryName);
            tvFactoryAddress = itemView.findViewById(R.id.tvFactoryAddress);
            tvFactoryCity = itemView.findViewById(R.id.tvFactoryCity);
            tvFactoryState = itemView.findViewById(R.id.tvFactoryState);
            tvFactoryPin = itemView.findViewById(R.id.tvFactoryPin);
            tvFactoryCountry = itemView.findViewById(R.id.tvFactoryCountry);
            tvCreatedDate = itemView.findViewById(R.id.tvCreatedDate);
            tvEdit1 = itemView.findViewById(R.id.tvEdit1);
            tvDelete1 = itemView.findViewById(R.id.tvDelete1);
        }
    }
}
