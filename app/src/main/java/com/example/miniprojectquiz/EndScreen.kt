package com.example.miniprojectquiz

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class EndScreen : AppCompatActivity() {
    private lateinit var scoreTextView: TextView
    private var score: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_screen)
        score = intent.getStringExtra("score")
        scoreTextView = findViewById(R.id.scoreTextView)
        scoreTextView.text = score + "/100"
    }

    // Código para conectarse a Twitter
    fun sendTweet(view: View) {
        val message =
            "He realizado el quiz de Marvin con una puntación de: \n${score}/100\n Crés que puedes hacerlo mejor? Descargaté la app hoy!!"
        val tweetIntent = Intent(Intent.ACTION_SEND)
        tweetIntent.type = "text/plain"
        tweetIntent.putExtra(Intent.EXTRA_TEXT, message)

        val packageManager = this.packageManager
        val twitterApps =
            packageManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY)

        var twitterAppFound = false
        for (app in twitterApps) {
            if (app.activityInfo.packageName.startsWith("com.twitter")) {
                tweetIntent.setPackage(app.activityInfo.packageName)
                twitterAppFound = true
                break
            }
        }
        if (twitterAppFound) {
            this.startActivity(tweetIntent)
        } else {
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://twitter.com/intent/tweet?text=" + message.replace(" ", "%20"))
            )
            this.startActivity(webIntent)
        }
    }

}