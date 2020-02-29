package com.example.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainFragment.FragmentInteractionListener {

    FragmentManager fragmentManager;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secondFragment = new SecondFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.first_container, new MainFragment(), "first")
                .addToBackStack("first")
                .commit();

//        fragmentManager
//                .beginTransaction()
//                .replace(R.id.container, new SecondFragment())
//                .commit();
    }


    @Override
    public void onInteract(int type) {
//        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentById(R.id.first_container);
        if (type == 1)
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.first_container, new SecondFragment())
                    .addToBackStack("second")
                    .commit();
        else if (type == 2)
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.first_container, new ThirdFragment())
                    .addToBackStack("third")
                    .commit();
        else {
//            fragmentManager.popBackStack();
            fragmentManager.popBackStack("first", 0);
            fragmentManager.popBackStack("second", 0);
        }
    }
}
