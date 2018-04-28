package adong.org.modiproject.service

import adong.org.modiproject.data.Status
import adong.org.modiproject.data.User
import adong.org.modiproject.data.UserGet
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService<T> {

    @POST("users")
    fun signup(@Body user : User) : Call<Status>

    @POST("sign")
    fun login(@Body user: User) : Call<UserGet>

}