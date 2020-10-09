package com.tetravalstartups.kgs.client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.client.model.Notification;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationDashboardAdapter extends RecyclerView.Adapter<NotificationDashboardAdapter.NotificationViewHolder> {

    private Context context;
    private List<Notification> clientDashboardList;

    public NotificationDashboardAdapter(Context context, List<Notification> clientDashboardList) {
        this.context = context;
        this.clientDashboardList = clientDashboardList;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_list, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        holder.tvNotHead.setText(clientDashboardList.get(position).getDescription());
        holder.tvClientHours.setText(clientDashboardList.get(position).getCreatedDate());

    }

    @Override
    public int getItemCount() {

        return clientDashboardList.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNotHead;
        private TextView tvNotSub;
        private TextView tvClientHours;
        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNotHead = itemView.findViewById(R.id.tvNotHead);
            tvNotSub = itemView.findViewById(R.id.tvNotSub);
            tvClientHours = itemView.findViewById(R.id.tvClientHours);
        }
    }
}
