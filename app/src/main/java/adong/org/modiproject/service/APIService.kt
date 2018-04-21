package adong.org.modiproject.service

import adong.org.modiproject.data.Token
import adong.org.modiproject.data.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {

    @POST("users")
    fun signup(@Body user : User) : Call<User>

    @POST("user")
    fun login(@Body user: User) : Call<User>

    @GET("token")
    fun token(token: Token) : Call<Token>
}