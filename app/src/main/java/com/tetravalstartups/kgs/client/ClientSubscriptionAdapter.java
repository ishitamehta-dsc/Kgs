package com.tetravalstartups.kgs.client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.ClientSubscriptionList;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClientSubscriptionAdapter extends RecyclerView.Adapter<ClientSubscriptionAdapter.ClientSubscriptionViewHolder>  {

    private Context context;
    private List<ClientSubscriptionList.Datum> clientSubscriptionList;

    public ClientSubscriptionAdapter(Context context, List<ClientSubscriptionList.Datum> clientSubscriptionList) {
        this.context = context;
        this.clientSubscriptionList = clientSubscriptionList;
    }

    @NonNull
    @Override
    public ClientSubscriptionAdapter.ClientSubscriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.client_subscription_list, parent, false);
        return new ClientSubscriptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientSubscriptionAdapter.ClientSubscriptionViewHolder holder, int position) {
        holder.tvTotal_Amount.setText(clientSubscriptionList.get(position).getTotalAmount());
        holder.tv_Amount_Paid.setText(clientSubscriptionList.get(position).getPaid());

        if (clientSubscriptionList.get(position).getPendingPayment() != null){
            holder.tvAmount_Pending.setText(clientSubscriptionList.get(position).getPendingPayment());
        }else {
            holder.tvAmount_Pending.setText("0");
        }

        holder.tvSubscriptionStart.setText(clientSubscriptionList.get(position).getSubStartDate());
        holder.tvSubscriptionEnd.setText(clientSubscriptionList.get(position).getSubEndDate());

        if (clientSubscriptionList.get(position).getStatus() == 1) {
            holder.tvSubs_Status.setText("Active");
            holder.tvSubs_Status.setTextColor(context.getResources().getColor(R.color.colorGreen));
        }
        else if (clientSubscriptionList.get(position).getStatus() == 0) {
            holder.tvSubs_Status.setText("Inactive");
            holder.tvSubs_Status.setTextColor(context.getResources().getColor(R.color.colorRed));
        }
    }

    @Override
    public int getItemCount() {
        return clientSubscriptionList.size();
    }

    public class ClientSubscriptionViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTotal_Amount;
        private TextView tv_Amount_Paid;
        private TextView tvAmount_Pending;
        private TextView tvSubscriptionStart;
        private TextView tvSubscriptionEnd;
        private TextView tvSubs_Status;

        public ClientSubscriptionViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTotal_Amount = itemView.findViewById(R.id.tvTotal_Amount);
            tv_Amount_Paid = itemView.findViewById(R.id.tv_Amount_Paid);
            tvAmount_Pending = itemView.findViewById(R.id.tvAmount_Pending);
            tvSubscriptionStart = itemView.findViewById(R.id.tvSubscriptionStart);
            tvSubscriptionEnd = itemView.findViewById(R.id.tvSubscriptionEnd);
            tvSubs_Status = itemView.findViewById(R.id.tvSubs_Status);

        }
    }
}
