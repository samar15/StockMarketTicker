package com.learning.ticker.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.learning.ticker.R;
import com.learning.ticker.model.TickerDto;

public class SummaryFragment extends BaseFragment {
    TextView symbol ;
    TextView exchange;
    TextView longName;
    TextView currentPrice;
    TextView changePrice;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.summary_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(null == getArguments()) {
            showToast("no ticker is selected", Toast.LENGTH_SHORT);
            return;
        }
        TickerDto tickerDto = getArguments().getParcelable("tickerDetails");
        symbol = (TextView) getView().findViewById(R.id.short_n);
        symbol.setText(tickerDto.getSymbol());
        exchange = (TextView) getView().findViewById(R.id.exchange);
        exchange.setText(tickerDto.getExchange());
        longName = (TextView) getView().findViewById(R.id.long_n);
        longName.setText(tickerDto.getLongName());
        currentPrice = (TextView) getView().findViewById(R.id.current_p);
        currentPrice.setText(String.valueOf(tickerDto.getRegularMarketPrice()));

        String change = String.valueOf(String.format("%.6f",tickerDto.getRegularMarketChange())) + "(" +
                String.valueOf(String.format("%.2f",tickerDto.getRegularMarketChangePercent())) + ")";

        changePrice = (TextView) getView().findViewById(R.id.change_p);
        changePrice.setText(change);

    }

}

