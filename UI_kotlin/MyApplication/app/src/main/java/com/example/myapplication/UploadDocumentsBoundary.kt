package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class UploadCertificates : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_certificates)
        val actionbar= supportActionBar
        if (actionbar!= null)
            actionbar.title = "Upload Certificates"

        }
    }
