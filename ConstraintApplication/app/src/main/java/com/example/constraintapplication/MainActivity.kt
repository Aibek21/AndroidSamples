package com.example.constraintapplication

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_new)
//        setLocale(Locale("ru"))

        val primaryLocale: Locale = this.resources.configuration.locales[0]
        val locale: String = primaryLocale.displayName
        Log.e("Local", locale)
    }


    private fun setLocale(locale: Locale) {
//        SharedPrefUtils.saveLocale(locale) // optional - Helper method to save the selected language to SharedPreferences in case you might need to attach to activity context (you will need to code this)
        val resources: Resources = resources
        val configuration: Configuration = resources.getConfiguration()
        val displayMetrics: DisplayMetrics = resources.getDisplayMetrics()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale)
        } else {
            configuration.locale = locale
        }
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            applicationContext.createConfigurationContext(configuration)
        } else {
            resources.updateConfiguration(configuration, displayMetrics)
        }
    }
}
