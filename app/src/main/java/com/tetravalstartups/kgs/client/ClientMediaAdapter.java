package com.tetravalstartups.kgs.client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.ClientMediaResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ClientMediaAdapter extends RecyclerView.Adapter<ClientMediaAdapter.ClientMediaViewHolder> {

    private Context context;
    private List<ClientMediaResponse> clientMediaList;

    public ClientMediaAdapter(Context context, List<ClientMediaResponse> clientMediaList){
        this.context = context;
        this.clientMediaList = clientMediaList;
    }


    @NonNull
    @Override
    public ClientMediaAdapter.ClientMediaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.client_factoryname_media_list, parent, false);
        return new ClientMediaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientMediaAdapter.ClientMediaViewHolder holder, int position) {
        holder.tvFactName.setText(clientMediaList.get(position).getFactoryName());
        holder.tvFactDate.setText(clientMediaList.get(position).getUploadDate());
    }

    @Override
    public int getItemCount() {
        return clientMediaList.size();
    }

    public class ClientMediaViewHolder extends RecyclerView.ViewHolder {

        private TextView tvFactDate;
        private TextView tvImage_Count;
        private TextView tvFactName;
        public ClientMediaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFactName = itemView.findViewById(R.id.tvFactName);
            tvFactDate = itemView.findViewById(R.id.tvFactDate);
            tvImage_Count = itemView.findViewById(R.id.tvImage_Count);
        }
    }
}
