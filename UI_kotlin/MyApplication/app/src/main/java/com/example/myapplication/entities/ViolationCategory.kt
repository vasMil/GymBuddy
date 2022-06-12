package com.example.myapplication.entities

interface ViolationCategory {
    val name: String
    val id: Int
    val importance: Int
    val rule: String
    val message: String
}