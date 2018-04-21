package adong.org.modiproject.adapter

import adong.org.modiproject.data.Token
import adong.org.modiproject.data.User
import ninja.sakib.pultusorm.annotations.AutoIncrement
import ninja.sakib.pultusorm.annotations.PrimaryKey

class LoginDB{
    @PrimaryKey
    @AutoIncrement
    var token : Token = Token("")
    var user : User = User("", "")
}