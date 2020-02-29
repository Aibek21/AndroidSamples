package com.example.fragmentapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {


    FragmentInteractionListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("MainFragment", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("MainFragment", "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("MainFragment", "onCreateView");
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("MainFragment", "onViewCreated");
        listener = (MainActivity) getActivity();
//        TextView textView = view.findViewById(R.id.mytext);
//        textView.setText("Hello");

        Button button = view.findViewById(R.id.go_to_second);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onInteract(1);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("MainFragment", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("MainFragment", "onStart");
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.e("MainFragment", "onResume");
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.e("MainFragment", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("MainFragment", "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("MainFragment", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MainFragment", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("MainFragment", "onDetach");
    }


    public interface FragmentInteractionListener {

        void onInteract(int type);
    }
}
