package adong.org.modiproject.data

//서버 상태 및 메시지
data class Result(val success : Boolean, val message : String)

//회원가입 및 로그인
data class User(val username : String, val password : String)
data class Token(val data: String = "")
data class Status(val status: Result, val user: User)
data class UserGet(val status : Result, val user : User, val token : Token)

//포스팅
data class Diaries(val tags : List<String>, val content : String)
data class DiariesGet(val status : Result, val diaries : Diaries)