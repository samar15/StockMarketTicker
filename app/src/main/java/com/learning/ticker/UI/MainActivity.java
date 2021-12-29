package com.learning.ticker.UI;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.learning.ticker.R;
import com.learning.ticker.adapter.RecyclerViewAdapter;
import com.learning.ticker.model.TickerAPIDto;
import com.learning.ticker.model.TickerDto;
import com.learning.ticker.network.JsonPlaceHolderApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private final String yahooHost = "https://yh-finance.p.rapidapi.com";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<TickerDto> tickerArrayList;
    private ArrayAdapter<String> arrayAdapter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Boolean isScrolling = false;
    private Integer currentItems;
    private Integer totalItems;
    private Integer scrollOutItems;
    private LinearLayoutManager manager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_fragment);
        tickerArrayList=new ArrayList<>();
        work();

        swipeRefreshLayout= findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                work();

            }
        });

    }


    public void work(){
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

//   network call
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofitApiCall(yahooHost ,this);
        Call<TickerAPIDto> call = jsonPlaceHolderApi.getTrendingTickers(
                "d08f396604msh1fadac93c72026ep15c4acjsn925c31325204","US");

        call.enqueue(new Callback<TickerAPIDto>() {
            @Override
            public void onResponse( Call<TickerAPIDto> call, Response<TickerAPIDto> response) {
                if(!response.isSuccessful() && null==response.body()){
                    showToast("an_error_has_occurred", Toast.LENGTH_SHORT);
                    return;
                }

                TickerAPIDto tickerAPIDto = response.body();
                if(tickerAPIDto != null){
                    tickerArrayList.addAll( tickerAPIDto.getFinance()
                            .getResult().get(0)
                            .getQuotes());
                }
                if(null==recyclerViewAdapter ) {
                    recyclerView();
                }else {
                    recyclerViewAdapter.notifyDataSetChanged();
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<TickerAPIDto> call, Throwable t) {
                showToast("api failed", Toast.LENGTH_SHORT);
            }
        });


    }


    public void recyclerView(){

        // recycler view
        recyclerView =findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        manager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(manager);
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,tickerArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling=true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = manager.getChildCount();
                totalItems = manager.getItemCount();
                scrollOutItems = manager.findFirstVisibleItemPosition();

                if(isScrolling && totalItems == currentItems+scrollOutItems)
                {
                    isScrolling = false;
                    fetchData();
                }

            }
        });

    }

    public void fetchData(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                work();
            }
        },2000);
    }

}
