package com.example.preferencessample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String str = "Initial";
    Context mContext;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE);

        str = sharedPreferences.getString("my_string", "Initial");
        Toast.makeText(mContext, str, Toast.LENGTH_LONG).show();

//        if (savedInstanceState != null) {
//            str = savedInstanceState.getString("my_string");
//            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
//        }

        Button button = findViewById(R.id.save_button);
        final EditText editText = findViewById(R.id.edit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = editText.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("my_string", str);
                editor.apply();
            }
        });


        Button remove_button = findViewById(R.id.remove_button);
        remove_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("my_string");
                editor.apply();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity", "onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("MainActivity", "onRestoreInstanceState");
//        str = savedInstanceState.getString("my_string");
//        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("my_string", str);
    }
}
