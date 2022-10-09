package com.example.lab_homework_unit4_f22_murad_khan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StatsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)
        var correctAnswers = findViewById<TextView>(R.id.tvQuestionscorrect)
        var wrongAnswers = findViewById<TextView>(R.id.tvWrongAnswers)
        var earnedPoint = findViewById<TextView>(R.id.tvEarnedpoints)
        var startOver = findViewById<Button>(R.id.Startagainbutton)
        var points = intent.getIntExtra("Points",0)
        var correctAnswer = intent.getIntExtra("CorrectAnswer",0)
        var wrongAnswerscount = 7 - correctAnswer
        wrongAnswers.text = "Wrong Answers: $wrongAnswerscount"
        correctAnswers.text = "Correct Answers: $correctAnswer"
        earnedPoint.text = "Earned Points: $points"
        startOver.setOnClickListener{
            val intent = Intent(this,QuestionsActivity1::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}