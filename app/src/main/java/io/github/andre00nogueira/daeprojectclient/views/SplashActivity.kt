package io.github.andre00nogueira.daeprojectclient.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.andre00nogueira.daeprojectclient.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TIME_BETWEEN_ACTIVITIES = 5000L

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        GlobalScope.launch(Dispatchers.Main) {
            delay(TIME_BETWEEN_ACTIVITIES)
            val mainActivityIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mainActivityIntent)
            finish()
        }
    }
}