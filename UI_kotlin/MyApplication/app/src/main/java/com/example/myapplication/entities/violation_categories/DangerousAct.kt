package com.example.myapplication.entities.violation_categories

import com.example.myapplication.entities.ViolationCategory

object DangerousAct : ViolationCategory {

    override val name: String = "Dangerous Act"
    override val id: Int = 3
    override val importance: Int = 4
    override val rule: String = "Videos that instruct dangerous technique or exercises are not allowed"
    override val message: String = "Video violates rules"
}