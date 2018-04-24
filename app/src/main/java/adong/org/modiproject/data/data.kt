package adong.org.modiproject.data

//회원가입 및 로그인
data class Result(val success : Boolean, val message : String)
data class Token(val data: String)
data class User(val username : String, val passwrod : String)
data class UserGet (val status : Result, val user : User, val token : Token)