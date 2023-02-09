package com.example.miniprojectquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class checkbox : AppCompatActivity() {
    private lateinit var firstQuestionElements: Array<CheckBox>
    private lateinit var secondQuestionElements: RadioGroup
    private lateinit var thirdQuestionElements: RadioGroup
    private lateinit var fourthQuestionElements: RadioGroup
    private lateinit var fifthQuestionElements: EditText
    private lateinit var sixthQuestionElements: Array<CheckBox>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)
        // variables para los elementos del quiz
        firstQuestionElements = arrayOf(
            findViewById(R.id.question1Awnser1),
            findViewById(R.id.question1Awnser2),
            findViewById(R.id.question1Awnser3),
            findViewById(R.id.question1Awnser4)
        )
        secondQuestionElements = findViewById(R.id.radioGroup1)
        thirdQuestionElements = findViewById(R.id.radioGroup2)
        fourthQuestionElements = findViewById(R.id.radioGroup3)
        fifthQuestionElements = findViewById(R.id.question5Awnser)
        sixthQuestionElements = arrayOf(
            findViewById(R.id.question6Awnser1),
            findViewById(R.id.question6Awnser2),
            findViewById(R.id.question6Awnser3),
            findViewById(R.id.question6Awnser4)
        )
    }

    // Mensajes de ánimo al usuario
    fun sendMessage(vista: View) {
        val comentarios = arrayOf(
            "Así se hace",
            "Estás que lo tiras",
            "Estás hecho un verdadero Friki",
            "Ya quedan menos",
            "¿Seguro de tu elección?",
            "De lo mejor que he visto",
            "Tu si que sabes",
            "Tienes bien compilado el tema",
            "Bien hecho humano",
            "Aún sigo siendo el androide más inteligente de la galaxia",
            "Yo te ayudaría si te hiciera falta",
            "Esa no era fácil"
        )
        Toast.makeText(
            applicationContext,
            comentarios[(Math.random() * comentarios.size).toInt()].toString(),
            Toast.LENGTH_SHORT
        ).show()
    }

    // Pasar a la ultima activity
    fun getResults(vista: View) {
        // Si no se ha contestado a todas las preguntas informamos con un Toast
        // de lo contrario calculamos score y cambiamos de activity
        if (validateFileds()) {
            //TODO: pass score to final screen
            val i = Intent(this, EndScreen::class.java)
            startActivity(i)
        } else {
            Toast.makeText(
                applicationContext,
                "Recuerda contestar todas las preguntas antes de continuar",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun validateFileds(): Boolean {
        var count1 = 0
        var count2 = 0
        for (i in firstQuestionElements) {
            if (!i.isChecked)
                count1 += 1
        }
        for (i in sixthQuestionElements) {
            if (!i.isChecked)
                count2 += 1
        }

        var values = arrayOf(
            count1 != 4,
            secondQuestionElements.getCheckedRadioButtonId() != -1,
            thirdQuestionElements.getCheckedRadioButtonId() != -1,
            fourthQuestionElements.getCheckedRadioButtonId() != -1,
            !fifthQuestionElements.text.isNullOrBlank(),
            count2 != 4
        )
        for (i in values){
            if (!i)
                return false
        }
        return true
    }


}