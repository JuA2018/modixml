package adong.org.modiproject.service;

import java.util.List;

import adong.org.modiproject.adapter.DBAdapter;
import adong.org.modiproject.adapter.LoginDB;
import adong.org.modiproject.data.Token;
import ninja.sakib.pultusorm.core.PultusORM;
import ninja.sakib.pultusorm.core.PultusORMCondition;
import ninja.sakib.pultusorm.core.PultusORMQuery;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private final static String BASE_URL = "http://112.158.99.134:3000";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

    public static Retrofit getLoginRetrofit() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            PultusORMCondition condition = new PultusORMCondition.Builder()
                    .sort("token", PultusORMQuery.Sort.DESCENDING)
                    .build();
            List<Object> token = new DBAdapter().loginORM.find(new LoginDB(), condition);
            Request request = original.newBuilder()
                    .header("authorization", token.get(0).toString())
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

}
