package com.learning.ticker.UI;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
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

public class HomeFragment extends BaseFragment {

    private final String yahooHost = "https://yh-finance.p.rapidapi.com";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<TickerDto> tickerArrayList;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Boolean isScrolling = false;
    private Integer currentItems;
    private Integer totalItems;
    private Integer scrollOutItems;
    private LinearLayoutManager manager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tickerArrayList=new ArrayList<>();
        work();

        swipeRefreshLayout= getView().findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                work();

            }
        });

    }


    public void work(){
        progressBar = getView().findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

//   network call
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofitApiCall(yahooHost ,getActivity());
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
                progressBar.setVisibility(View.GONE);
            }
        });


    }


    public void recyclerView(){

        // recycler view
        recyclerView =getView().findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerViewAdapter = new RecyclerViewAdapter(getActivity(),tickerArrayList);
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

