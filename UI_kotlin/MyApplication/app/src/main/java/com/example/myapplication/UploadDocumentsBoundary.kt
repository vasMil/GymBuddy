package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.*
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class UploadCertificates : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_certificates)
        displayUploadDocs()
        becomeTrainer()
    }

      private fun displayUploadDocs(){
        val uploadCertificatesButton= findViewById<Button>(R.id.uploadCertificatesBtn)
        uploadCertificatesButton.setOnClickListener{
            //Toast.makeText(applicationContext, "Upload Documents", Toast.LENGTH_SHORT ).show()
            val intent = Intent(this, UploadDocs :: class.java )
            startActivity(intent)
        }
}


    private fun displayAppComp() { }


    private fun becomeTrainer(){
        val actionbar = supportActionBar
        this.title = "Upload Certificates"
        with(actionbar) {
        this!!.title = "Upload Certificates"
        setDisplayHomeAsUpEnabled(true)
        }
    }


}
// this class refers on UploadDocuments -> use case
class UploadDocs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_documents)

        uploadDocuments()
    }

    private fun uploadDocuments() {
        val docName = findViewById<EditText>(R.id.docName)
        val nextButton = findViewById<Button>(R.id.next_button)

        // if user doesn't upload the documents then return message
        nextButton.setOnClickListener {
            if (isEmpty(docName.text.toString())) {
                Snackbar.make(docName, "invalid documents", Snackbar.LENGTH_SHORT).show();

                val intent = Intent(this, UploadCertificates::class.java)

            } else {
                displayTrainerApplication()
            }
        }
    }

    private fun displayTrainerApplication(){
        val docName = findViewById<EditText>(R.id.docName)
        val intent = Intent(this@UploadDocs, TrainerApplicationBoundary :: class.java )
        intent.putExtra("docName", docName.text.toString())
        startActivity(intent)
    }




}