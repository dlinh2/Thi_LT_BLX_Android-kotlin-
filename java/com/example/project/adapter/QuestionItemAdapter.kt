package com.example.project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.model.QuestionModel


class QuestionItemAdapter(var context:Context, val listQuestion: List<QuestionModel>, var callback: (Int, String) -> Unit):
                        RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
//    var listQuestion:List<QuestionModel> = listQuestion

    companion object {
        const val THE_FIRST_VIEW = 1
        const val THE_SECOND_VIEW = 2
    }
    private inner class ItemView1Holder(private val view: View) : RecyclerView.ViewHolder(view){
        val idQues = view.findViewById<TextView>(R.id.idQuestion)
        val ques = view.findViewById<TextView>(R.id.ques)
        val ans_button1 = view.findViewById<RadioButton>(R.id.answer1)
        val ans_button2 = view.findViewById<RadioButton>(R.id.answer2)
        val ans_button3 = view.findViewById<RadioButton>(R.id.answer3)
        val ans_button4 = view.findViewById<RadioButton>(R.id.answer4)
        fun bind(position: Int){
            val item = listQuestion[position]
            idQues.setText("Câu " + item.id + ":")
            ques.setText(item.questionText)
            ans_button1.setText(item.answer1);
            ans_button2.setText(item.answer2);
            ans_button3.setText(item.answer3)
            ans_button4.setText(item.answer4);
            if(item.answer3 == null){
                ans_button3.setVisibility(View.GONE);
            }
            else
                ans_button3.setVisibility(View.VISIBLE);
            if(item.answer4 == null){
                ans_button4.setVisibility(View.GONE);
            }
            else
                ans_button4.setVisibility(View.VISIBLE);
            ans_button1.setOnClickListener{
                callback(position, item.answer1)
            }
            ans_button2.setOnClickListener{
                callback(position, item.answer2)
            }
            ans_button3.setOnClickListener{
                callback(position, item?.answer3.toString())
            }
            ans_button4.setOnClickListener{
                callback(position, item?.answer4.toString())
            }
        }
    }
    private inner class ItemView2Holder(private val view: View) : RecyclerView.ViewHolder(view){
        val idQues = view.findViewById<TextView>(R.id.idQuestion1)
        val imageQues = view.findViewById<ImageView>(R.id.itemImage1)
        val ques = view.findViewById<TextView>(R.id.ques1)
        val ans_button1 = view.findViewById<RadioButton>(R.id.answer1_1)
        val ans_button2 = view.findViewById<RadioButton>(R.id.answer2_1)
        val ans_button3 = view.findViewById<RadioButton>(R.id.answer3_1)
        val ans_button4 = view.findViewById<RadioButton>(R.id.answer4_1)
        fun bind(position: Int){
            val item = listQuestion[position]
            idQues.setText("Câu " + item.id + ":")
            ques.setText(item.questionText)
            imageQues.setImageResource(item.imageId)
            ans_button1.setText(item.answer1);
            ans_button2.setText(item.answer2);
            ans_button3.setText(item.answer3)
            ans_button4.setText(item.answer4);
            if(item.answer3 == null){
                ans_button3.setVisibility(View.GONE);
            }
            else
                ans_button3.setVisibility(View.VISIBLE);
            if(item.answer4 == null){
                ans_button4.setVisibility(View.GONE);
            }
            else
                ans_button4.setVisibility(View.VISIBLE);
            ans_button1.setOnClickListener{
                callback(position, item.answer1)
            }
            ans_button2.setOnClickListener{
                callback(position, item.answer2)
            }
            ans_button3.setOnClickListener{
                callback(position, item?.answer3.toString())
            }
            ans_button4.setOnClickListener{
                callback(position, item?.answer4.toString())
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, theView: Int): RecyclerView.ViewHolder {
        if(theView == THE_FIRST_VIEW){
            return ItemView1Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
        }
        return ItemView2Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout1,parent,false))

    }

    override fun getItemCount(): Int {
        return listQuestion.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(listQuestion[position].theView == THE_FIRST_VIEW){
            ( holder as ItemView1Holder).bind(position)
        }
        else
            (holder as ItemView2Holder).bind(position)

    }
    override fun getItemViewType(position: Int): Int {
        return listQuestion[position].theView
    }





}


