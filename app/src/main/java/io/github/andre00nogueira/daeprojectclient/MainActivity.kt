package io.github.andre00nogueira.daeprojectclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.andre00nogueira.daeprojectclient.data.ProjectAPIService
import io.github.andre00nogueira.daeprojectclient.data.material.MaterialResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val projectAPIService = ProjectAPIService()
        GlobalScope.launch(Dispatchers.IO) {
            // Example
            projectAPIService.getAllProjectists()
        }
    }
}