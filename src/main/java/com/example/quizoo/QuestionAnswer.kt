package com.example.quizoo

class QuestionAnswer {

    companion object {
        val question = arrayOf(
            "What is 10+28 ?",
            "Who invented Telephone?",
            "what is 12*9 ?",
            "who is the founder of SpaceX?",
            "In the given options, which is the Example of System Software?"
        )

        val choices = arrayOf(
            arrayOf("32", "42", "36", "38"),
            arrayOf("Graham Bell", "Einstein", "Edison", "None of the above"),
            arrayOf("96", "84", "102", "108"),
            arrayOf("Jeff Bezos", "Elon Musk", "Steve Jobs", "Bill Gates"),
            arrayOf("Windows", "Linux", "MacOS", "All of the above")
        )

        val correctAnswers = arrayOf(
            "38",
            "Graham Bell",
            "108",
            "Elon Musk",
            "All of the above"
        )
    }
}