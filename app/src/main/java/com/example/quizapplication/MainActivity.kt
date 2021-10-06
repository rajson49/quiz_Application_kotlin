package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        startBtn.setOnClickListener {

            if (etName.text.toString().isEmpty()){
                Toast.makeText(this@MainActivity,"Please Enter Your Name",Toast.LENGTH_SHORT).show()
            }else{

                Log.i(Constacts.USER_NAME,etName.text.toString())
                val intent=Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(Constacts.USER_NAME,etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}