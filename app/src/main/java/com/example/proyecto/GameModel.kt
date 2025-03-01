package com.example.proyecto

import androidx.lifecycle.ViewModel

class GameModel : ViewModel() {
     var allQuestions = mutableListOf<QuestionWithAnswers>()
     var gameQuestions = mutableListOf<QuestionWithAnswers>()
     var NumberOfQuestions = 0
     var currentQuestionIndex = 0
     var questionAnswers = mutableListOf<List<String>>()
    var gameDifficulty = 0
     var score = 0
     var questionsAnswered = 0
     var questionsAnsweredCorrectly = 0
     var hintsRemaining = 0
     var hintsUsed = 0

    private var consecutiveAnswersCorrectly = 0

/*
    init {
        allQuestions.add(
            Question(
                "¿Cuál es la extensión territorial de la CDMX?",
                "1,485 km2",
                listOf("1,845 km2", "2,172 km2", "937 km2"),
                "Geografía",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "¿Cuál es el estado más pequeño de México?",
                "CDMX",
                listOf("Colima", "Tlaxcala", "Morelos"),
                "Geografía",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "¿A qué estado le pertenece la ciudad de Tijuana?",
                "Baja California",
                listOf("Baja California Sur", "California", "Sonora"),
                "Geografía",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "¿Cuál es el rio más grande del mundo?",
                "Amazonas",
                listOf("Nilo", "Mississippi", "Congo"),
                "Geografía",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "¿Cuántos oceanos hay en el mundo?",
                "5",
                listOf("7", "2", "4"),
                "Geografía",
                false,
                "",
                false
            )
        )

        allQuestions.add(
            Question(
                "¿Quién es el autor de la frase 'Pienso luego existo'?",
                "Descartes",
                listOf("Locke", "Socrates", "Platón"),
                "Cultura General",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "¿Cuál no es una maravilla del mundo moderno?",
                "La tumba de Tutankamón",
                listOf("La muralla china", "Chichen Itzá", "Las pirámides de Giza"),
                "Cultura General",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "¿En qué año se descubrió América?",
                "1492",
                listOf("1576", "1824", "1342"),
                "Cultura General",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "¿Cuántos litros de sangre tiene una persona adulta?",
                "4 - 6 L",
                listOf("2 - 4 L", "7+ L", "5 - 7 L"),
                "Cultura General",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "¿Qué continente no es parte del viejo mundo?",
                "América",
                listOf("África", "Asia", "Europa"),
                "Cultura General",
                false,
                "",
                false
            )
        )

        allQuestions.add(
            Question(
                "¿Cuántos reinos animales existen?",
                "5",
                listOf("9", "12", "17"),
                "Animales",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "¿Qué tipo de animal es el tiburón?",
                "Pez",
                listOf("Mamífero", "Anfibio", "Reptil"),
                "Animales",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "Los animales que tienen el cuerpo cubierto por una escama dura y áspera se llaman...",
                "Reptiles",
                listOf("Mamíferos", "Anfibios", "Peces"),
                "Animales",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "Las esponjas son animales invertebrados de la familia de los...",
                "Poríferos",
                listOf("Insectos", "Gusanos", "Moluscos"),
                "Animales",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "Los animales invertebrados, que tienen 4 pares de patas y no poseen antenas, se llaman...",
                "Arácnidos",
                listOf("Insectos", "Crustaceos", "Poríferos"),
                "Animales",
                false,
                "",
                false
            )
        )

        allQuestions.add(
            Question(
                "¿Quién es el protagonista de 'The Legend of Zelda'?",
                "Link",
                listOf("Zelda", "Ganondorf", "Impa"),
                "Videojuegos",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "¿Cuál es el juego más vendido de la historia?",
                "Wii Sports",
                listOf("Tetris", "Super Mario", "Pokemon Red/Blue"),
                "Videojuegos",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "¿En cuál fue el primer juego en donde apareció el personaje 'Mario'?",
                "Donkey Kong",
                listOf("Super Mario Bros", "Super Smash Brothers 64", "The Legend of Zelda"),
                "Videojuegos",
                false,
                "",
                false
            )
        )

        allQuestions.add(
            Question(
                "¿Cuántos luchadores hay en Street Fighter II?",
                "12",
                listOf("8", "10", "16"),
                "Videojuegos",
                false,
                "",
                false
            )
        )
        allQuestions.add(
            Question(
                "¿Cuál juego de los siguientes salió primero?",
                "Pong",
                listOf("Tetris", "Pac-man", "Sonic"),
                "Videojuegos",
                false,
                "",
                false
            )
        )

    }
*/

    fun GetRandomQuestions(difficulty: Int, questions: List<QuestionWithAnswers>) {


        allQuestions.addAll(questions)

        for (i in 0 ..9){
            //val randInt = Random.nextInt(allQuestions.size)
            //var question = allQuestions[randInt]
            //gameQuestions.add(question)
            allQuestions.shuffle()
            var question: QuestionWithAnswers = allQuestions.random()
            while (gameQuestions.contains(question)){
                question = allQuestions.random()
            }
            gameQuestions.add(question)

            var answers = mutableListOf<String>()

            for (ans in question.answers){
                if (ans.correct){
                    answers.add(ans.content)
                }
            }

            var wrongAnswer = question.answers.random()
            answers.add(wrongAnswer.content)
            for (i in 2..difficulty) {
                while (answers.indexOf(wrongAnswer.content) != -1) {
                    wrongAnswer = question.answers.random()
                }
                answers.add(wrongAnswer.content)
            }
            answers.shuffle()
            questionAnswers.add(answers)
        }
        NumberOfQuestions = gameQuestions.size
    }
    fun setHints(num: Int){
        hintsRemaining = num
    }
    fun GetQuestionAnswers(): List<String> {
        return questionAnswers[currentQuestionIndex]
    }
    fun getDifficultyString(): String{
        if (gameDifficulty==1){ return "Fácil" }
        if (gameDifficulty==2){ return "Normal" }
        if (gameDifficulty==3){ return "Difícil" }
        return ""
    }

    val getQuestionsAnsweredCorrectly: Int
        get() = questionsAnsweredCorrectly

    val getAnsweredQuestion: Int
        get() = questionsAnswered

    val getScore: Int
        get()= score

    val TotalNumberOfQuestions: Int
        get() = NumberOfQuestions

    val currentQuestion: QuestionWithAnswers
        get() = gameQuestions[currentQuestionIndex]

    val currentQuestionText: String
        get() = gameQuestions[currentQuestionIndex].question.question

    val currentQuestionAnswer: String?
        get() = getCorrectAnswer(gameQuestions[currentQuestionIndex])

    val questionNumber: Int
        get() = currentQuestionIndex +1

    val isEmpty: Boolean
         get() = gameQuestions.size == 0

    val getHints: Int
        get() = hintsRemaining

    val getHintsUsed: Int
        get() = hintsUsed

    val getConsecutiveAnswersCorrectly : Int
        get() = consecutiveAnswersCorrectly
    val questionHints: Boolean
        get() = gameQuestions[currentQuestionIndex].question.hintsUsed
    fun addQuestionAnsweredCorrectly(){
        questionsAnsweredCorrectly++
    }

    fun addConsecutiveAnswerCorrectly(){
        consecutiveAnswersCorrectly++
    }
    fun restartConsecutiveAnsweredCorrectly(){
        consecutiveAnswersCorrectly = 0
    }

    fun useHint(){
        if (hintsRemaining >= 1) {
            hintsRemaining -= 1
            hintsUsed++
            score-=20
            consecutiveAnswersCorrectly = 0
            if(!gameQuestions[currentQuestionIndex].question.hintsUsed){
                gameQuestions[currentQuestionIndex].question.question = "${gameQuestions[currentQuestionIndex].question}(Pista usada)"
                gameQuestions[currentQuestionIndex].question.hintsUsed = true

            }
        }
    }
    fun addHint(){
        hintsRemaining++
    }

    fun nextQuestion(){
        currentQuestionIndex = (currentQuestionIndex + 1) % gameQuestions.size
    }

    fun prevQuestion(){
        if(currentQuestionIndex >= 0) {
            currentQuestionIndex--
        }
        if (currentQuestionIndex == -1){
            currentQuestionIndex = gameQuestions.size -1
        }
    }

    fun Answer(){
        questionsAnswered++
    }

    fun addScore(){ score+=100}

    val IsFinished: Boolean
        get() = questionsAnswered == gameQuestions.size

    fun getCorrectAnswer(questionWithAnswers: QuestionWithAnswers): String?{
        for (ans in questionWithAnswers.answers)
        {
            if (ans.correct)
            {
                return ans.content
            }
        }
        return ""
    }
}