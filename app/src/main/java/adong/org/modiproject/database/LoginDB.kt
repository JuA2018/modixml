package adong.org.modiproject.database

import ninja.sakib.pultusorm.annotations.AutoIncrement
import ninja.sakib.pultusorm.annotations.PrimaryKey

class LoginDB {
    @PrimaryKey
    @AutoIncrement
    var token : String = ""
    var userid : String = ""
}