package com.example.quizapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_final_result.*

class FinalResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)

        val mMarks=intent.getStringExtra(Constacts.USER_MARKS)
        val mName=intent.getStringExtra(Constacts.USER_NAME)

        name.text=mName
        marks.text=mMarks

        Log.i(Constacts.USER_NAME,mMarks+" "+mName)

        finishBtn.setOnClickListener {
            val i=Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        }

    }


}