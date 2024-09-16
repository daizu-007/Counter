package io.github.daizu007.counter

import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // ここから自分のコードを書く
        var count = 0
        val plus_button = findViewById<Button>(R.id.plus_button)
        val minus_button = findViewById<Button>(R.id.minus_button)
        val reset_button = findViewById<Button>(R.id.reset_button)
        val count_text = findViewById<TextView>(R.id.count_text)
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        plus_button.setOnClickListener {
            count += 1
            count_text.text = count.toString()
            vibrator.vibrate(10)
        }
        minus_button.setOnClickListener {
            if (count == 0) return@setOnClickListener
            count -= 1
            count_text.text = count.toString()
            vibrator.vibrate(10)
        }
        reset_button.setOnClickListener {
            count = 0
            count_text.text = count.toString()
            vibrator.vibrate(50)
        }
    }
}