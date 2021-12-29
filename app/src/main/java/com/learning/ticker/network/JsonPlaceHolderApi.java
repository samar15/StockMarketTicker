package com.learning.ticker.network;

import com.learning.ticker.model.OtpApiDto;
import com.learning.ticker.model.TickerAPIDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

   @GET("/api/v1/otp/last")
    Call<OtpApiDto> getOtps();

   @GET("/market/get-trending-tickers")
    Call<TickerAPIDto> getTrendingTickers(@Header("x-rapidapi-key") String key
            , @Query("region") String region );
}
