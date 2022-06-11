package com.example.myapplication

import androidx.core.app.ActivityCompat
import java.io.Serializable
import java.util.jar.Manifest

open class User(name: String, id: Int) : UserInterface {
    var name = name
    override val id = id
    var location: Pair<Int, Int>? = null
    var age: Int? = null
    var isBanned = false
        set(value) {
            if(UserSession.getUser<Admin>() == null) {
                return
            }
            field = true
        }

    constructor(name: String, id: Int, location: Pair<Int, Int>, age: Int) : this(name, id) {
        this.location = location
        this.age = age
    }
}