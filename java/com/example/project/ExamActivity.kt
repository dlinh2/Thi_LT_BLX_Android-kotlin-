package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.adapter.QuestionItemAdapter
import com.example.project.dataSource.QuestionDataSource
import com.example.project.model.QuestionModel
import java.text.DecimalFormat


class ExamActivity : AppCompatActivity(){

    lateinit var textView : TextView
    lateinit var listQuestion: List<QuestionModel>;
    var listSelect = arrayOfNulls<String>(25)


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam)
        val recyclerView = findViewById<RecyclerView>(R.id.mainRecycleView)
        listQuestion = QuestionDataSource().getListQuestion()
        recyclerView.adapter = QuestionItemAdapter(this, listQuestion, ::callbackSelectAnswer)
        Log.d("choice",listSelect.toString())
        textView = findViewById(R.id.countdown)
        object : CountDownTimer(1140000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var f = DecimalFormat("00")
                var min = (millisUntilFinished / 60000) % 60;
                var sec = (millisUntilFinished / 1000) % 60;
                textView.setText("" + f.format(min) + ":" + f.format(sec))
            }

            override fun onFinish() {
                val intent = Intent(this@ExamActivity, EndActivity::class.java);
                intent.putExtra("result", listSelect)
                startActivity(intent);
            }
        }.start()
        val buttonEnd = findViewById<Button>(R.id.buttonEnd)
        buttonEnd.setOnClickListener {
            val intent = Intent(this, EndActivity::class.java)
            intent.putExtra("result", listSelect)
            startActivity(intent)
        }

        }

    public fun callbackSelectAnswer(position: Int, answer: String) {
//        Log.d("test", "you select " + answer)
        listSelect.set(position,answer)
    }

}





