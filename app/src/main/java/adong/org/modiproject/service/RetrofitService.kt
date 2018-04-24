package adong.org.modiproject.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    val BASE_URL = "http://112.158.99.134:3000"

    lateinit var retrofit : Retrofit
    fun getClient() : Retrofit{
        val intercepter = HttpLoggingInterceptor()
        intercepter.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .addInterceptor(intercepter)
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        return  retrofit
    }
}