package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.project.adapter.QuestionItemAdapter
import com.example.project.dataSource.QuestionDataSource


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.buttonStart)
        button.setOnClickListener {
            val intent = Intent(this, ExamActivity::class.java)
            startActivity(intent)
        }

    }

}