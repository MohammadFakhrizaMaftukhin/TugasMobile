package com.example.smt4

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.concurrent.Executors

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val db = ColorDatabase.getInstance(this)
        val executor = Executors.newSingleThreadExecutor() // Buat background thread

        executor.execute {
            val colorRed = Color(hexColor = "#ff0000", name = "Red") // Jangan isi ID
            db.colorDao().insert(colorRed)

            // Cek apakah data masuk
            val colors = db.colorDao().getAll()
            Log.d("Database", "Colors in DB: $colors")
        }
    }
}