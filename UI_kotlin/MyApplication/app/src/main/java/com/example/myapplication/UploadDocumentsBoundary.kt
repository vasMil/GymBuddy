package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UploadCertificates : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_certificates)
        displayUploadDocs()
        becomeTrainer()
        uploadDocuments()


    }
      private fun displayUploadDocs(){

        val uploadCertificatesButton= findViewById<Button>(R.id.uploadCertificatesBtn)
        uploadCertificatesButton.setOnClickListener{
            Toast.makeText(applicationContext, "Upload Documents", Toast.LENGTH_SHORT ).show()
        }

    }
    private fun becomeTrainer(){
        val actionbar = supportActionBar
        this.title = "Upload Certificates"
        with(actionbar) {
        this!!.title = "Upload Certificates"
        setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun uploadDocuments(){
        // TODO : upload the documents by user

    }


}
