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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String str = "Initial";
    Context mContext;
    SharedPreferences sharedPreferences;
    AppDatabase db;
    ContactDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE);
        db = MyApplication.getInstance().getDatabase();
        contactDao = db.contactDao();
//        str = sharedPreferences.getString("my_string", "Initial");
//        Toast.makeText(mContext, str, Toast.LENGTH_LONG).show();

//        if (savedInstanceState != null) {
//            str = savedInstanceState.getString("my_string");
//            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
//        }

        Button button = findViewById(R.id.save_button);
        final EditText idEdit = findViewById(R.id.id_edit);
        final EditText nameEdit = findViewById(R.id.name);
        final EditText phoneEdit = findViewById(R.id.phone);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = nameEdit.getText().toString();
                String phoneStr = phoneEdit.getText().toString();

                Contact contact = new Contact();
                contact.name = nameStr;
                contact.phone = phoneStr;
                contactDao.insert(contact);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("my_string", str);
//                editor.apply();
            }
        });


        Button remove_button = findViewById(R.id.get_contacts_button);
        remove_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Contact> contacts = contactDao.getContacts();
                for (Contact contact : contacts) {
                    Log.e("Contact", contact.id + " " + contact.name + " " + contact.phone);
                }
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.remove("my_string");
//                editor.apply();
            }
        });


        Button updateButton = findViewById(R.id.update_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(idEdit.getText().toString());
                Contact contact = contactDao.getContactById(id);
                contact.name = nameEdit.getText().toString();
                contact.phone = phoneEdit.getText().toString();
                contactDao.update(contact);
            }
        });


        Button deleteButton = findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(idEdit.getText().toString());
                Contact contact = contactDao.getContactById(id);
                contactDao.delete(contact);
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
