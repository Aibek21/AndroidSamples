package com.example.recyclerviewapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        val userJson = sharedPreferences.getString("user", "")
        if (userJson!!.isNotEmpty()) {
            val user = Gson().fromJson(userJson, User::class.java)
            Log.d("MainActivity", user.name)
        }
//        val user = intent.getParcelableExtra<User>("user")


        val users = ArrayList<User>()
        for (i in 1..100) {
            users.add(User("Name" + i, "", "employee", 20 + i))
        }

        val userListAdapter = UserListAdapter(users, this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        val layoutManager = GridLayoutManager(this, 5)
//        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = userListAdapter
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_logout) {
            val editor = sharedPreferences.edit()
            editor.remove("user")
            editor.apply()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        return true
    }


}
