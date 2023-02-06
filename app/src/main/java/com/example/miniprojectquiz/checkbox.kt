package com.example.miniprojectquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class checkbox : AppCompatActivity() {
    private lateinit var comentarios: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        // Comentarios de
        val comentarios = arrayOf(
            "Así se hace",
            "Estás que lo tiras",
            "Estás hecho un verdadero Friki",
            "Ya quedan menos",
            "¿Seguro de tu elección?",
            "De lo mejor que he visto",
            "Tu si que sabes",
            "Conoces el tema",
            "Te ayudaría si te hiciera falta",
            "No muy rapido pero si seguro"
        )
    }

    fun sendMessage(vista: View){
        Toast.makeText(applicationContext, comentarios.get((Math.random()*comentarios.length).toInt()).toString(), Toast.LENGTH_SHORT).show()
    }

    fun getResults(vista: View) {
        val i = Intent(this, checkbox::class.java)
        startActivity(i)
    }
}