package com.example.lab_homework_unit4_f22_murad_khan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.forEach

class QuestionActivity4 : AppCompatActivity() {
    var points = 0
    var correctAnswers = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question4)
        var radioGroup = findViewById<RadioGroup>(R.id.rgAnswerSelection)
        var moneyCounting = findViewById<TextView>(R.id.tvMoneycounter)
        var questionPerson = findViewById<TextView>(R.id.tvQuestion)
        var confirmButton = findViewById<Button>(R.id.Confirmbutton)
        var lastQuizPoint = intent.getIntExtra("Points",0)
        correctAnswers = intent.getIntExtra("CorrectAnswer",0)
        radioGroup.setOnCheckedChangeListener { radioGroups, checkedId ->

            val checkedRadioButton = radioGroups.findViewById<RadioButton>(checkedId)
            // This puts the value (true/false) into the variable
            val isChecked = checkedRadioButton.isChecked
            // If the radiobutton that has changed in check state is now checked...
            if (isChecked) {
// Changes the background color
                checkedRadioButton.setBackgroundColor(resources.getColor(R.color.teal_200 ))

            }
            radioGroup.forEach { //make all other radio buttons white
                if(it.id!=checkedId){
                    val radioButton = radioGroups.findViewById<RadioButton>(it.id)
                    radioButton.setBackgroundColor(resources.getColor(R.color.white ))

                }
            }

        }
        moneyCounting.text = "You Earned: $lastQuizPoint"
        confirmButton.setOnClickListener {
            var selectedId = radioGroup.checkedRadioButtonId
            var radioAnswers = findViewById<RadioButton>(selectedId);
            if (radioAnswers.text == "Thriller") {
                if (lastQuizPoint != null) {
                    correctAnswers += 1
                    points = 100+lastQuizPoint.toInt()
                }
                moneyCounting.text = "You Earned: $points"
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show()
            } else {
                if (lastQuizPoint != null) {
                    points = 0+lastQuizPoint.toInt()
                }
                correctAnswers += 0
                moneyCounting.text = "You Earned: $points"
                Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show()
            }
            val intent = Intent(this,QuestionActivity5::class.java)
            intent.putExtra("Points",points)//sending the data to next activity
            intent.putExtra("CorrectAnswer",correctAnswers)

            startActivity(intent)


        }

    }
}





