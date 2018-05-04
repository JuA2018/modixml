package adong.org.modiproject.data

import java.util.*

//서버 상태 및 메시지
data class Result(val success : Boolean, val message : String)

//회원가입 및 로그인
data class User(val username : String, val password : String)
data class Token(val data: String = "")
data class Status(val status: Result, val user: User)
data class UserGet(val status : Result, val user : User, val token : Token)

//다이얼리 포스트
//tag는 stringbuffe로 합쳐서 string으로 형변환 해서 보내기
data class Diaries(val tags : String, val contents : String, val createdAt : String)
data class DiariesGet(val status : Result, val diaries : List<Diaries>)

//mainactivity Recyclerview data class
class Diarielist(val days : String="", val tags : ArrayList<String> = arrayListOf(""), val contents : String="")