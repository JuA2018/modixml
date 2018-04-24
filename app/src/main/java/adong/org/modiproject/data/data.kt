package adong.org.modiproject.data

//회원가입 및 로그인
data class Result(val success : Boolean, val message : String)
data class UserGet (val status : Result, val user : User, val token : Token)