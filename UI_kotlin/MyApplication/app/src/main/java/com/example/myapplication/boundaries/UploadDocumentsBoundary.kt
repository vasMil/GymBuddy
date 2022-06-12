package com.example.myapplication.boundaries

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.entities.TrainerApplication
import com.google.android.material.snackbar.Snackbar

class UploadDocumentsBoundary : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_documents)
        supportActionBar?.apply {
            title = "Upload Documents"
            setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.main_color)))
        }
        uploadDocuments()
    }

    private fun uploadDocuments() {
        val docName = findViewById<EditText>(R.id.docName)
        val nextButton = findViewById<Button>(R.id.next_button)

        // if user doesn't upload the documents then return message
        nextButton.setOnClickListener {
            if (isEmpty(docName.text.toString())) {
                Snackbar.make(docName, "invalid documents", Snackbar.LENGTH_SHORT).show();
            } else {
                displayTrainerApplication()
            }
        }
    }

    private fun displayTrainerApplication(){
        // Create a TrainerApplication
        val docName = findViewById<EditText>(R.id.docName)
        val trainerApplication = TrainerApplication(docName.text.toString())
        val intent = Intent(this, PreviewTrainerApplicationBoundary::class.java )
        intent.putExtra("trainerApplication", trainerApplication)
        startActivity(intent)
    }

}
