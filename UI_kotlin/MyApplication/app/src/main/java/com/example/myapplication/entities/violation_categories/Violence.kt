package com.example.myapplication.entities.violation_categories

import com.example.myapplication.entities.ViolationCategory

object Violence : ViolationCategory {

    override val name: String = "Violence"
    override val id: Int = 2
    override val importance: Int = 6
    override val rule: String = "Videos or pictures should not contain or promote any kind of" +
            "violence"
    override val message: String = "Video violates rules"
}