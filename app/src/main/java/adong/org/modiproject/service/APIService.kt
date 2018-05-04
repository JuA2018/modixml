package adong.org.modiproject.service

import adong.org.modiproject.data.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService<T> {

    @POST("users")
    fun signup(@Body user : User) : Call<Status>

    @POST("sign")
    fun login(@Body user: User) : Call<UserGet>

    @POST("write")
    fun diarywrite(@Body diaries: Diaries) : Call<DiariesGet>

    @GET("write")
    fun getdiary() : Call<DiariesGet>

}