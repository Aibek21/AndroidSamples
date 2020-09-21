package com.example.kotlinsampleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    , View.OnClickListener {

    private var counter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Log.e("MainActivity", "onCreate")
//        counter = savedInstanceState?.getDouble("counter") ?: Math.random() * 10


//        button1.setOnClickListener { view ->
//            counter++
//            text1.text = counter.toString()
//        }

//        button1.setOnClickListener(this)
//        text1.setOnClickListener(this)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("MainActivity", "onSaveInstanceState")
//        outState.putDouble("counter", counter)
    }

//    fun onClick(p0: View?) {
//        when (p0?.id) {
//            button1.id -> {
//                counter++
//                text1.text = counter.toString()
//            }
//            text1.id -> {
//                counter = 0
//                text1.text = counter.toString()
//            }
//        }
//    }

    fun onClickButton(view: View?) {
        counter++
        text1.text = counter.toString()
    }

    fun onClickText(view: View?) {
        counter = 0
        text1.text = counter.toString()
    }


//    override fun onClick(p0: View?) {
//        when (p0?.id) {
//            button1.id -> {
//                counter++
//                text1.text = counter.toString()
//            }
//            text1.id -> {
//                counter = 0
//                text1.text = counter.toString()
//            }
//        }
//    }
//    override fun onStart() {
//        super.onStart()
//        Log.e("MainActivity", "onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.e("MainActivity", "onResume")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.e("MainActivity", "onRestart")
//    }
//
//
//    override fun onPause() {
//        super.onPause()
//        Log.e("MainActivity", "onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.e("MainActivity", "onStop")
//    }
//
//    override fun onDestroy() {
////        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show()
//        Log.e("MainActivity", "onDestroy")
//        super.onDestroy()
//    }
}
