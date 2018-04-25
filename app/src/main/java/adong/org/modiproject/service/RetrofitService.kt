package adong.org.modiproject.service

import adong.org.modiproject.data.Token
import android.text.TextUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    val BASE_URL = "http://112.158.99.134:3000"

    val httpclient = OkHttpClient.Builder()
    val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpclient.build())

    lateinit var retrofit : Retrofit

    fun <T> creatService(serviceClass : Class<T>) : T {
        retrofit = builder.build()
        return retrofit.create(serviceClass)
    }
    fun <T> creatService(serviceClass : Class<T>, authToken : String) : T{
        if (!TextUtils.isEmpty(authToken)){
            val interceptor = AuthenticationInterceptor(Token().data)
            if (!httpclient.interceptors().contains(interceptor)){
                httpclient.addInterceptor(interceptor)

                builder.client(httpclient.build())
                retrofit = builder.build()
            }
        }
        return retrofit.create(serviceClass)
    }
}

class AuthenticationInterceptor(val authToken : String) : Interceptor{

    override fun intercept(chain: Interceptor.Chain?): Response {
        val original = chain!!.request()

        val builder = original.newBuilder()
                .header("Authorization",  authToken)

        val request = builder.build()
        return chain.proceed(request)
    }

}
