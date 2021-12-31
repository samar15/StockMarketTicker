package com.learning.ticker.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.learning.ticker.R;
import com.learning.ticker.UI.MainActivity;
import com.learning.ticker.UI.SummaryFragment;
import com.learning.ticker.model.TickerDto;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.TickerViewHolder> {
    private Context context;
    private List<TickerDto> tickers;

    public  RecyclerViewAdapter(Context context , List<TickerDto> tickers){
        this.context= context;
        this.tickers = tickers;

    }
    @NonNull
    @Override
    public RecyclerViewAdapter.TickerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TickerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TickerViewHolder holder, int position) {
        TickerDto ticker = tickers.get(position);

        String change = String.valueOf(String.format("%.6f",ticker.getRegularMarketChange())) + "(" +
                String.valueOf(String.format("%.2f",ticker.getRegularMarketChangePercent())) + ")";


        holder.symbol.setText(ticker.getSymbol());
        holder.shortName .setText(ticker.getShortName());
        holder.currentPrice . setText(String.valueOf(ticker.getRegularMarketPrice()));
        holder.changePrice.setText(change);

            if(0>ticker.getRegularMarketChangePercent()){
                holder.changePrice.setTextColor(ContextCompat.getColor(context.getApplicationContext(), R.color.red));
            }
    }

    @Override
    public int getItemCount() {
        return tickers.size();
    }


    class TickerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView symbol;
        public TextView shortName;
        public TextView currentPrice;
        public TextView changePrice;

        public TickerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            symbol = (TextView) itemView.findViewById(R.id.symbol);
            shortName = (TextView) itemView.findViewById(R.id.short_name);
            currentPrice = (TextView) itemView.findViewById(R.id.current_price);
            changePrice = (TextView) itemView.findViewById(R.id.change);

        }


        @Override
        public void onClick(View view) {
            int position = this.getAbsoluteAdapterPosition();
            TickerDto tickerDto = tickers.get(position);
            SummaryFragment fragment = new SummaryFragment();
            Bundle arguments = new Bundle();
            arguments.putParcelable("tickerDetails",tickerDto);
            fragment.setArguments(arguments);
            ((MainActivity)context).addFragment(fragment,R.id.fragment_container);
         }
        }
    }
