package com.example.fragmentapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    val args: SecondFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("SecondFragment", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("SecondFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("SecondFragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("SecondFragment", "onViewCreated")
        Log.e("SecondFragmentArgs", args.todoId.toString())

        go_to_third.setOnClickListener {
            val bundle = bundleOf("amount" to "amount is 100")
            it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
//            (activity as MainActivity).changeFragment(2)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("SecondFragment", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.e("SecondFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("SecondFragment", "onResume")
    }


    override fun onPause() {
        super.onPause()
        Log.e("SecondFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("SecondFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("SecondFragment", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("SecondFragment", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("SecondFragment", "onDetach")

    }
}