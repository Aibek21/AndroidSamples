package com.example.recyclerviewapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.edit
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val user = sharedPreferences.getString("user", "")
        if (user!!.isNotEmpty()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        setContentView(R.layout.activity_login)
    }


    fun onClick(view: View) {
        val username = username_edit.text.toString()
        val password = password_edit.text.toString()
        val position = position_edit.text.toString()
        val age = age_edit.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()) {
            val user = User(username, password, position, age.toInt())

            val editor = sharedPreferences.edit()
            val userJson = Gson().toJson(user)
            Log.d("User JSON", userJson)
            editor.putString("user", userJson)
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
//            intent.putExtra("user", user)
            startActivity(intent)
        }
    }
}
