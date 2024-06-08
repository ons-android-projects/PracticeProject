package com.ons.androidtutorial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val TAG ="Lifecycle"

class MainActivity : AppCompatActivity() {

    private var counter = 0
    private lateinit var button: Button
    private lateinit var firstActivityBtn: Button
    private lateinit var nameField: EditText
    private lateinit var textView: TextView
    private lateinit var toastBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: call")
        button = findViewById(R.id.clickBtn)
        firstActivityBtn = findViewById(R.id.firstActivity)
        textView = findViewById(R.id.counerTv)
        nameField = findViewById(R.id.nameEd)
        toastBtn = findViewById(R.id.toastButton)

        button.setOnClickListener {
            counter++
            textView.text = "Counter is $counter"
        }
        firstActivityBtn.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            intent.putExtra("name", nameField.text.toString())
            startActivity(intent)
        }
        toastBtn.setOnClickListener {
            Toast.makeText(this, "You are seeing a Toast message", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: call")
    }

    override fun onResume() {
        super.onResume()
        textView.text = "Counter is $counter"
        Log.d(TAG, "onResume: call")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: call")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
      //  outState.putInt("counter", counter)
        Log.d(TAG, "onSaveInstanceState: call")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
     //   counter = savedInstanceState.getInt("counter")
        Log.d(TAG, "onRestoreInstanceState: call")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: call")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: call")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: call")
    }

}