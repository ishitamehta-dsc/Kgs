package com.tetravalstartups.kgs.client;

import android.content.Context;
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

    @Override
    public void onBindViewHolder(@NonNull ClientFactoryAdapter.ClientFactoryViewHolder holder, int position) {
        holder.tvFname1.setText(clientFactoryList.get(position).getLocationName());
    }

    @Override
    public int getItemCount() {
        return clientFactoryList.size();
    }

    public class ClientFactoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFname1;
        private TextView tvEdit1;
        private TextView tvDelete1;
        public ClientFactoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFname1 = itemView.findViewById(R.id.tvFname1);
            tvEdit1 = itemView.findViewById(R.id.tvEdit1);
            tvDelete1 = itemView.findViewById(R.id.tvDelete1);
        }
    }
}
