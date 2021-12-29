package com.learning.ticker.UI;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.learning.ticker.R;
import com.learning.ticker.network.JsonPlaceHolderApi;
import com.readystatesoftware.chuck.ChuckInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseFragment extends Fragment {
    public JsonPlaceHolderApi retrofitApiCall(String host, Context context){
// chuck interceptor
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ChuckInterceptor(context))
                .build();

        //logging interceptor
        OkHttpClient loggingInterceptor= new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(JsonPlaceHolderApi.class);
    }

    public void showToast(String text, int duration ){
        View layout = getLayoutInflater().inflate(R.layout.custom_toast_layout,(ViewGroup) getView().findViewById(R.id.toast_layout));
        Toast toast = new Toast(getActivity().getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        TextView toastText = layout.findViewById(R.id.toast_text);
        toastText.setText(text);
        toast.setDuration(duration);
        toast.setView(layout);
        toast.show();
    }
}
