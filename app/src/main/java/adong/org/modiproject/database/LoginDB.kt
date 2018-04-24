package adong.org.modiproject.database

import ninja.sakib.pultusorm.annotations.AutoIncrement
import ninja.sakib.pultusorm.annotations.PrimaryKey

class LoginDB {
    @PrimaryKey
    @AutoIncrement
    var token : String = ""
    var userid : String = ""
}

/*
val logindb = LoginDB()
                            logindb.token = response.body()!!.token.data
                            logindb.userid = response.body()!!.user.username
                            DBAdapter().loginDB.save(logindb)
 */