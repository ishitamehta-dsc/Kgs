package com.tetravalstartups.kgs.client.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tetravalstartups.kgs.R;
import com.tetravalstartups.kgs.auth.model.ClientInvoiceList;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClientInvoiceAdapter extends RecyclerView.Adapter<ClientInvoiceAdapter.ClientInvoiceViewHolder> {

    private Context context;
    private List<ClientSubscriptionResponse> clientInvoiceList;

    public ClientInvoiceAdapter(Context context, List<ClientSubscriptionResponse> clientInvoiceList) {
        this.context = context;
        this.clientInvoiceList = clientInvoiceList;
    }

    @NonNull
    @Override
    public ClientInvoiceAdapter.ClientInvoiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.client_invoice_list, parent, false);
        return new ClientInvoiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientInvoiceAdapter.ClientInvoiceViewHolder holder, int position) {
        ClientSubscriptionResponse data = clientInvoiceList.get(position);
        //holder.tvInvoice_Id.setText(clientInvoiceList.get(position).);

    }

    @Override
    public int getItemCount() {
        return clientInvoiceList.size();
    }

    public class ClientInvoiceViewHolder extends RecyclerView.ViewHolder {
        private TextView tvInvoice_Id;
        private TextView tvInvoice_Date;
        private TextView tvSubs_Paid_Amt;
        private TextView tvInvoice_Discount;
        private TextView tvInvoice_Total_Amt;

        public ClientInvoiceViewHolder(@NonNull View itemView) {
            super(itemView);

            tvInvoice_Id = itemView.findViewById(R.id.tvInvoice_Id);
            tvInvoice_Date = itemView.findViewById(R.id.tvInvoice_Date);
            tvSubs_Paid_Amt = itemView.findViewById(R.id.tvSubs_Paid_Amt);
            tvInvoice_Discount = itemView.findViewById(R.id.tvInvoice_Discount);
            tvInvoice_Total_Amt = itemView.findViewById(R.id.tvInvoice_Total_Amt);
        }
    }
}
