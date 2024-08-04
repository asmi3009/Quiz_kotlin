package com.example.quizoo

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var questionTextView: TextView
    private lateinit var totalQuestionTextView: TextView
    private lateinit var ansA: Button
    private lateinit var ansB: Button
    private lateinit var ansC: Button
    private lateinit var ansD: Button
    private lateinit var btnSubmit: Button
    private var score: Int = 0
    private val totalQuestion: Int = QuestionAnswer.question.size
    private var currentQuestionIndex: Int = 0
    private var selectedAnswer: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        totalQuestionTextView = findViewById(R.id.total_question)
        questionTextView = findViewById(R.id.question)
        ansA = findViewById(R.id.ans_a)
        ansB = findViewById(R.id.ans_b)
        ansC = findViewById(R.id.ans_c)
        ansD = findViewById(R.id.ans_d)
        btnSubmit = findViewById(R.id.btn_submit)

        ansA.setOnClickListener(this)
        ansB.setOnClickListener(this)
        ansC.setOnClickListener(this)
        ansD.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

        totalQuestionTextView.text = "Total question: $totalQuestion"

        loadNewQuestion()
    }

    private fun loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz()
            return
        }
        questionTextView.text = QuestionAnswer.question[currentQuestionIndex]
        ansA.text = QuestionAnswer.choices[currentQuestionIndex][0]
        ansB.text = QuestionAnswer.choices[currentQuestionIndex][1]
        ansC.text = QuestionAnswer.choices[currentQuestionIndex][2]
        ansD.text = QuestionAnswer.choices[currentQuestionIndex][3]

        selectedAnswer = ""
    }

    private fun finishQuiz() {
        val passStatus = if (score >= totalQuestion * 0.6) "Passed" else "Failed"
        AlertDialog.Builder(this)
            .setTitle(passStatus)
            .setMessage("Your Score is $score Out of $totalQuestion")
            .setPositiveButton("Restart") { _, _ -> restartQuiz() }
            .setCancelable(false)
            .show()
    }

    private fun restartQuiz() {
        score = 0
        currentQuestionIndex = 0
        loadNewQuestion()
    }

    override fun onClick(view: View) {
        ansA.setBackgroundColor(resources.getColor(R.color.white))
        ansB.setBackgroundColor(resources.getColor(R.color.white))
        ansC.setBackgroundColor(resources.getColor(R.color.white))
        ansD.setBackgroundColor(resources.getColor(R.color.white))

        val clickedButton = view as Button

        if (clickedButton.id == R.id.btn_submit) {
            if (selectedAnswer.isNotEmpty()) {
                if (selectedAnswer == QuestionAnswer.correctAnswers[currentQuestionIndex]) {
                    score++
                } else {
                    clickedButton.setBackgroundColor(resources.getColor(R.color.magenta))
                }
                currentQuestionIndex++
                loadNewQuestion()
            } else {

            }
        } else {
            selectedAnswer = clickedButton.text.toString()
            clickedButton.setBackgroundColor(resources.getColor(R.color.yellow))
        }
    }
}