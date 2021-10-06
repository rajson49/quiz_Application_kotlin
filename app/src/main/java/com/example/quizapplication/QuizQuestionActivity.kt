package com.example.quizapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_final_result.*
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity() , View.OnClickListener{

    private var mCurrentPosition:Int=0
    private var mQuestionList:ArrayList<Questions>?=null
    private var mSelectedOptionPosition:Int=0
    private var mUserName:String?=null
    private var mCorrectAns:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName=intent.getStringExtra(Constacts.USER_NAME)


        Log.i(Constacts.USER_NAME,mUserName.toString())

        mQuestionList=Constacts.getQuestions()

        Log.i("Question Size=","${mQuestionList!!.size}")

        init()

        setQuestion()

    }

    fun init(){

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        submitBtn.setOnClickListener(this)
    }


    private fun setQuestion() {

        val question = mQuestionList!!.get(mCurrentPosition) // Getting the question from the list with the help of current position.

        defualtOptionView()

        if (mCurrentPosition == (mQuestionList!!.size-1)) {
            submitBtn.text = "FINISH"
        } else {
            submitBtn.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        tvQuestion.text = question.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour

    }

    private fun defualtOptionView(){

        val options=ArrayList<TextView>()

        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.defualt_option_border_bg)
        }

    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.tv_option_one->{
                    selectedOptionView(tv_option_one,1)
                    checkAnswer(1)
            }
            R.id.tv_option_two->{
                selectedOptionView(tv_option_two,2)
                checkAnswer(2)

            }
            R.id.tv_option_three->{
                selectedOptionView(tv_option_three,3)
                checkAnswer(3)

            }
            R.id.tv_option_four->{
                selectedOptionView(tv_option_four,4)
                checkAnswer(4)

            }
            R.id.submitBtn->{

                mCurrentPosition += 1


                if (mCurrentPosition == (mQuestionList!!.size)) {

                    val intent= Intent(this,FinalResultActivity::class.java)
                    intent.putExtra(Constacts.USER_NAME,mUserName)
                    intent.putExtra(Constacts.USER_MARKS,mCorrectAns.toString())
                    startActivity(intent)
                    finish()
                }else{

                    setQuestion()
                }


            }
        }
    }

    private fun checkAnswer(choicedOption:Int) {

        val question= mQuestionList!![mCurrentPosition]

        Log.i(Constacts.USER_NAME,mCurrentPosition.toString())

        if(question.correctAnswer ==choicedOption){

            mCorrectAns+=1

            when(choicedOption){
                1->tv_option_one.background=ContextCompat.getDrawable(this,R.drawable.right_answer_selected)
                2->tv_option_two.background=ContextCompat.getDrawable(this,R.drawable.right_answer_selected)
                3->tv_option_three.background=ContextCompat.getDrawable(this,R.drawable.right_answer_selected)
                4->tv_option_four.background=ContextCompat.getDrawable(this,R.drawable.right_answer_selected)
            }

        }else{

            when(choicedOption){
                1->tv_option_one.background=ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                2->tv_option_two.background=ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                3->tv_option_three.background=ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
                4->tv_option_four.background=ContextCompat.getDrawable(this,R.drawable.wrong_option_border_bg)
            }

        }
    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{ tv_option_one.background=ContextCompat.getDrawable(this,drawableView) }
            2->{tv_option_two.background=ContextCompat.getDrawable(this,drawableView)}
            3->{tv_option_three.background=ContextCompat.getDrawable(this,drawableView)}
            4->{tv_option_four.background=ContextCompat.getDrawable(this,drawableView)}
        }
    }


    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){

        defualtOptionView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.typeface= Typeface.DEFAULT
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border)

    }


}