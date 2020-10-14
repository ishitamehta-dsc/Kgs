package com.tetravalstartups.kgs.staff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.StaffNotification;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class StaffNotificationAdapter extends RecyclerView.Adapter<StaffNotificationAdapter.StaffNotificationViewHolder> {
    private Context context;
    private List<StaffNotification> staffNotification;

    public StaffNotificationAdapter(Context context, String staffNotificationList) {
        this.context = context;
        this.staffNotification = staffNotification;
    }

    @NonNull
    @Override
    public StaffNotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_list, parent, false);
        return new StaffNotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffNotificationViewHolder holder, int position) {
        holder.tvClientHours.setText(staffNotification.get(position).getMessage());
        holder.tvNotHead.setText(staffNotification.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return staffNotification.size();
    }

    public class StaffNotificationViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNotHead;
        private TextView tvClientHours;
        public StaffNotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNotHead = itemView.findViewById(R.id.tvNotHead);
            tvClientHours = itemView.findViewById(R.id.tvClientHours);
        }
    }
}
