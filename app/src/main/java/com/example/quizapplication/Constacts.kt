package com.example.quizapplication

object Constacts {

    val USER_MARKS="USER_MARKS"
    val USER_NAME="USER_NAME"

    fun getQuestions():ArrayList<Questions>{

        val questionList=ArrayList<Questions>()

        val que1=Questions(1,"What County does this flag belog to?",

                R.drawable.ic_flag_of_argentina,
                "argentina",
            "australia",
            "india",
            "wakanda",
            1
            )
        questionList.add(que1)

        // 2
        val que2 = Questions(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

        questionList.add(que2)

        // 3
        val que3 = Questions(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        questionList.add(que3)

        // 4
        val que4 = Questions(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        questionList.add(que4)

        // 5
        val que5 = Questions(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        questionList.add(que5)

        // 6
        val que6 = Questions(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        questionList.add(que6)

        // 7
        val que7 = Questions(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        questionList.add(que7)

        // 8
        val que8 = Questions(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        questionList.add(que8)

        // 9
        val que9 = Questions(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        questionList.add(que9)

        // 10
        val que10 = Questions(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        questionList.add(que10)

        return questionList
    }

}