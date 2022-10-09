package com.example.lab_homework_unit4_f22_murad_khan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(Looper.getMainLooper()).postDelayed({
            var splash = Intent(this,QuestionsActivity1::class.java) //Creating the intent to move to the next screen
            startActivity(splash)//Is used to run the intent
            finish()// to end the splash screen and to any activity

        },3000)// to delay the splashscreen
    }
}