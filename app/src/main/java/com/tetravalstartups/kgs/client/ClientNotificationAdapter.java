package com.tetravalstartups.kgs.client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.ClientNotification;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ClientNotificationAdapter extends RecyclerView.Adapter<ClientNotificationAdapter.ClientNotificationViewHolder> {
    private Context context;
    private List<ClientNotification.Notification> clientNotificationList;

    public ClientNotificationAdapter(Context context, List<ClientNotification.Notification> clientNotificationList) {
        this.context = context;
        this.clientNotificationList = clientNotificationList;
    }

    @NonNull
    @Override
    public ClientNotificationAdapter.ClientNotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_list, parent, false);
        return new ClientNotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientNotificationAdapter.ClientNotificationViewHolder holder, int position) {
        holder.tvClientHours.setText(clientNotificationList.get(position).getCreatedDate());
        holder.tvNotHead.setText(clientNotificationList.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return clientNotificationList.size();
    }

    public class ClientNotificationViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNotHead;
        private TextView tvClientHours;
        public ClientNotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNotHead = itemView.findViewById(R.id.tvNotHead);
            tvClientHours = itemView.findViewById(R.id.tvClientHours);
        }
    }
}
