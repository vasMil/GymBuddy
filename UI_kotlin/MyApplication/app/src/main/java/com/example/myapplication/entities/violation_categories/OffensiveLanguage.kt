package com.example.myapplication.entities.violation_categories

import com.example.myapplication.entities.ViolationCategory

object OffensiveLanguage : ViolationCategory {
    override val name: String = "Offensive Language"
    override val id: Int = 1
    override val importance: Int = 2
    override val rule: String = "Users should be kind in their interactions, " +
            "offensive language will not be tolerated"
    override val message: String = "You are not allowed to use this word!"
}