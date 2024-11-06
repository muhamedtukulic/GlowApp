package com.example.myapplication.ui.screens
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun QuizzScreen(navController: NavController) {

    var question1: Question = Question(
        "Do you often wake up with a shine all over your face?",
        _answers = listOf(
            Answer("Yes", _points = 1),
            Answer("Sometimes", _points = 2),
            Answer("No", _points = 3)
        ))
    var question2: Question = Question(
        "You washed your skind with lukewarm water and did not apply any skincare products to it afterwards. Does your skin feel tight?",
        _answers = listOf(
            Answer("Yes", _points = 3),
            Answer("Sometimes", _points = 2),
            Answer("No", _points = 1)
        ))
    var question3: Question = Question(
        "Do you frequently experience redness or irritation on your skin?",
        _answers = listOf(
            Answer("Yes", _points = 3),
            Answer("Sometimes", _points = 2),
            Answer("No", _points = 1)
        ))
    var question4: Question = Question(
        "Does your skin burn or itch after applying skincare products?",
        _answers = listOf(
            Answer("Yes", _points = 3),
            Answer("Sometimes", _points = 2),
            Answer("No", _points = 1)
        ))
    var question5: Question = Question(
        "Does your skin get very red or iritated from products that have a string fragrance?",
        _answers = listOf(
            Answer("Yes", _points = 3),
            Answer("Sometimes", _points = 2),
            Answer("No", _points = 1)
        ))
    var question6: Question = Question(
        "You got up in the morning, washed your face with lukewarm water and applied your favourite moisturizer. Does your skin look red?",
        _answers = listOf(
            Answer("Yes", _points = 3),
            Answer("Sometimes", _points = 2),
            Answer("No", _points = 1)
        ))
    var question7: Question = Question(
        "Do you have a lot witeheads or bumps appearing on a weekly basis?",
        _answers = listOf(
            Answer("Yes", _points = 3),
            Answer("Sometimes", _points = 2),
            Answer("No", _points = 1)
        ))
    var question8: Question = Question(
        "Do you often get new pimples after wearing SPF?",
        _answers = listOf(
            Answer("Yes", _points = 1),
            Answer("Sometimes", _points = 2),
            Answer("No", _points = 3)
        ))
    var question9: Question = Question(
        "Does your diet reflect on your skind and acne?",
        _answers = listOf(
            Answer("Yes", _points = 1),
            Answer("Sometimes", _points = 2),
            Answer("No", _points = 3)
        ))




    val questions: List<Question> = listOf(question1, question2,question3,question4,question5,question6,question7,question8,question9 )

    var currentQuestionIndex by remember { mutableStateOf(0) }
    var pointsCount by remember { mutableStateOf(0) }
    var quizCompleted by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val currentQuestion = questions[currentQuestionIndex]

        Text(
            text = "Quizz",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        if (quizCompleted)  {
            Text(
                text = "The Quiz is complete.",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            val skinType = getSkinType(pointsCount)
            Text(
                text = getSkinTypeMessage(skinType = skinType),
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(vertical = 20.dp))

            Button(onClick = {
                navController.navigate("skinRoutine/${skinType.name}")
            }, modifier = Modifier.padding(vertical = 4.dp)) {
                Text(
                    text = "Click here to check your skin routine",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Divider()
            }


        } else {

            Text(
                text = currentQuestion.title,
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(vertical = 30.dp))
            Spacer(modifier = Modifier.height(10.dp))

            currentQuestion.answers.forEachIndexed { index, answer ->
                Button(onClick = {
                    pointsCount += answer.points

                    if (currentQuestionIndex == questions.lastIndex ) {
                        quizCompleted = true
                    } else {
                        currentQuestionIndex++
                    }
                }, modifier = Modifier.padding(vertical = 4.dp)) {
                    Text(
                        text = answer.title,
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Divider()
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Points: $pointsCount",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

enum class SkinType {
    OILY,
    COMBINED,
    DRY
}

fun getSkinType(points: Int): SkinType {
    return when (points) {
        in 0..17 -> SkinType.OILY
        in 18..21 -> SkinType.COMBINED
        else -> SkinType.DRY
    }
}

fun getSkinTypeMessage(skinType: SkinType): String {
    return when (skinType) {
        SkinType.OILY -> "Your skin type is oily."
        SkinType.COMBINED -> "Your skin type is combined."
        SkinType.DRY -> "Your skin type is dry."
    }
}

class Question(_title: String, _answers: List<Answer>) {
    var title: String = _title
    var answers: List<Answer> = _answers
}

class Answer(_title: String, _points: Int) {
    var title: String = _title
    var points: Int = _points
}
