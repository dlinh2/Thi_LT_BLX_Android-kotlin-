package com.example.project.adapter

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.view.accessibility.AccessibilityEvent
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.model.QuestionModel

class QuestionItemResultAdapter(var context:Context, var listQuestion: List<QuestionModel>, var listSelect: Array<String?> = arrayOfNulls<String>(25))
    : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    companion object {
        const val THE_FIRST_VIEW = 1
        const val THE_SECOND_VIEW = 2
    }
    private inner class ItemViewRHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val idQuesR = view.findViewById<TextView>(R.id.idQuestionR)
        val quesR = view.findViewById<TextView>(R.id.quesR)
        val ans_button1R = view.findViewById<RadioButton>(R.id.answer1R)
        val ans_button2R = view.findViewById<RadioButton>(R.id.answer2R)
        val ans_button3R = view.findViewById<RadioButton>(R.id.answer3R)
        val ans_button4R = view.findViewById<RadioButton>(R.id.answer4R)
        val notice = view.findViewById<TextView>(R.id.notice)
        fun bind(position: Int){
            val item = listQuestion[position]
            idQuesR.setText("Câu " +(position + 1).toString() + ":")
            quesR.setText(item.questionText);
            ans_button1R.setText(item.answer1);
            ans_button2R.setText(item.answer2);
            ans_button3R.setText(item.answer3)
            ans_button4R.setText(item.answer4);
            if(item.answer3 == null){
                ans_button3R.setVisibility(View.GONE);
            }
            else
                ans_button3R.setVisibility(View.VISIBLE);
            if(item.answer4 == null){
                ans_button4R.setVisibility(View.GONE);
            }
            else
                ans_button4R.setVisibility(View.VISIBLE);

            if(listSelect[position] == ans_button1R.text){
                ans_button1R.setChecked(true)
            }
            else if(listSelect[position] == ans_button2R.text){
                ans_button2R.setChecked(true)

            }
            else if(listSelect[position] == ans_button3R.text){
                ans_button3R?.setChecked(true)
            }
            else{
                ans_button4R?.setChecked(true)
            }
            if(listSelect[position] == listQuestion[position].answer){
                notice.setText("Bạn đã chọn đúng")
                notice.setTextColor(Color.GREEN)
            }
            else if(listSelect[position] == null){
                notice.setText("Bạn chưa chọn. Đáp án đúng là: " + listQuestion[position].answer)
                notice.setTextColor(Color.RED)
            }
            else{
                notice.setText("Bạn đã chọn sai. Đáp án đúng là: " + listQuestion[position].answer)
                notice.setTextColor(Color.RED)
            }
        }

    }

    private inner class ItemView1RHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val idQuesR = view.findViewById<TextView>(R.id.idQuestionR1)
        val quesR = view.findViewById<TextView>(R.id.quesR1)
        val imageQues = view.findViewById<ImageView>(R.id.itemImageR1)
        val ans_button1R = view.findViewById<RadioButton>(R.id.answer1R_1)
        val ans_button2R = view.findViewById<RadioButton>(R.id.answer2R_1)
        val ans_button3R = view.findViewById<RadioButton>(R.id.answer3R_1)
        val ans_button4R = view.findViewById<RadioButton>(R.id.answer4R_1)
        val notice = view.findViewById<TextView>(R.id.notice1)
        fun bind(position: Int){
            val item = listQuestion[position]
            idQuesR.setText("Câu " +(position + 1).toString() + ":")
            quesR.setText(item.questionText);
            imageQues.setImageResource(item.imageId)
            ans_button1R.setText(item.answer1);
            ans_button2R.setText(item.answer2);
            ans_button3R.setText(item.answer3)
            ans_button4R.setText(item.answer4);
            if(item.answer3 == null){
                ans_button3R.setVisibility(View.GONE);
            }
            else
                ans_button3R.setVisibility(View.VISIBLE);
            if(item.answer4 == null){
                ans_button4R.setVisibility(View.GONE);
            }
            else
                ans_button4R.setVisibility(View.VISIBLE);

            if(listSelect[position] == ans_button1R.text){
                ans_button1R.setChecked(true)
            }
            else if(listSelect[position] == ans_button2R.text){
                ans_button2R.setChecked(true)

            }
            else if(listSelect[position] == ans_button3R.text){
                ans_button3R?.setChecked(true)
            }
            else{
                ans_button4R?.setChecked(true)
            }
            if(listSelect[position] == listQuestion[position].answer){
                notice.setText("Bạn đã chọn đúng")
                notice.setTextColor(Color.GREEN)
            }
            else if(listSelect[position] == null){
                notice.setText("Bạn chưa chọn. Đáp án đúng là: " + listQuestion[position].answer)
                notice.setTextColor(Color.RED)
            }
            else{
                notice.setText("Bạn đã chọn sai. Đáp án đúng là: " + listQuestion[position].answer)
                notice.setTextColor(Color.RED)
            }
        }

    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(listQuestion[position].theView == THE_FIRST_VIEW){
            (holder as ItemViewRHolder).bind(position)
        }
        else
            (holder as ItemView1RHolder).bind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, theView: Int): RecyclerView.ViewHolder {
        if(theView == THE_FIRST_VIEW){
            return ItemViewRHolder(LayoutInflater.from(parent.context).inflate(R.layout.itemresult_layout,parent,false))
        }
        return ItemView1RHolder(LayoutInflater.from(parent.context).inflate(R.layout.itemresult_layout1,parent,false))
    }

    override fun getItemCount(): Int {
        return listQuestion.size
    }
    override fun getItemViewType(position: Int): Int {
        return listQuestion[position].theView
    }




}