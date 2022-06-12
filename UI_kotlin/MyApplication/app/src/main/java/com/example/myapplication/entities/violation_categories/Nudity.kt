package com.example.myapplication.entities.violation_categories

import com.example.myapplication.entities.ViolationCategory

object Nudity : ViolationCategory {

    override val name: String = "Nudity"
    override val id: Int = 0
    override val importance: Int = 7
    override val rule: String = "Videos or pictures of nude people are not allowed"
    override val message: String = "Video violates rules"
}