package com.example.fragmentapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    var status = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.second_fragment_container, SecondFragment())
//            .addToBackStack("initial")
//            .commit()
    }


    override fun onSupportNavigateUp(): Boolean =
        findNavController(R.id.nav_host_fragment).navigateUp()

//    fun changeFragment(type: Int) {
//        when (type) {
//            1 -> {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.second_fragment_container, ThirdFragment())
//                    .addToBackStack("third").commit()
//            }
//            2 -> {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.second_fragment_container, FirstFragment())
//                    .addToBackStack("first").commit()
//            }
//        }
//    }

    fun onClick(view: View) {
//        if (status == 0) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.second_fragment_container, ThirdFragment())
//                .addToBackStack("third").commit()
//            status = 1
//        } else {
//            supportFragmentManager.popBackStack("third", 0)
//            status = 0
//        }
//
//        val intent = Intent(this, SecondActivity::class.java)
//        intent.putExtra("message", "Hello from MainActivity!")
//        startActivity(intent)
    }
}
