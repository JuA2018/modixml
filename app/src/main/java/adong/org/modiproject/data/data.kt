package adong.org.modiproject.data

//회원가입 및 로그인
data class User(val username : String, val password : String)
data class Token(val data: String)
data class Result(val success : Boolean, val message : String)
data class Status(val status: Result, val user: User)
data class UserGet(val status : Result, val user : User, val token : Token)
