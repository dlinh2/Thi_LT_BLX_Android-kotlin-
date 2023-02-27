package com.example.project

import android.content.Intent
import android.graphics.Color
import android.icu.lang.UProperty.NameChoice
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.adapter.QuestionItemResultAdapter
import com.example.project.dataSource.QuestionDataSource
import com.example.project.model.QuestionModel
import com.google.android.material.color.utilities.Score

class EndActivity : AppCompatActivity() {
    private var Score:Int = 0;
    lateinit var listQuestion: List<QuestionModel>;
    var listSelect  = arrayOfNulls<String>(25);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        val intent = intent
        listSelect = intent.getStringArrayExtra("result") as Array<String?>
        val recyclerView = findViewById<RecyclerView>(R.id.mainRecycleViewR)
        listQuestion = QuestionDataSource().getListQuestion()
        recyclerView.adapter = QuestionItemResultAdapter(this,listQuestion, listSelect)
        val buttonFinish = findViewById<ImageButton>(R.id.buttonFinish)
        buttonFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        Score();
        val numQues = findViewById<TextView>(R.id.textViewNumQues)
        numQues.setText(Score.toString() + "/25")
        val result = findViewById<TextView>(R.id.textViewResult)
        if(Score >= 21){
            result.setText("Đạt")
            result.setTextColor(Color.GREEN)
        }
        else {
            result.setText("Không Đạt")
            result.setTextColor(Color.RED)
        }
    }
    private fun Score(){
        for(i in listSelect.indices){
            if(listSelect[i] == listQuestion[i].answer){
                Score++;
            }
        }
    }


}