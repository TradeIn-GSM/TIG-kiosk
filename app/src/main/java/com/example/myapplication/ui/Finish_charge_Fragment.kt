package com.example.myapplication.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R


class Finish_charge_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mHandler = Handler()
        mHandler.postDelayed(Runnable {
            findNavController().navigate(R.id.action_finish_charge_Fragment_to_loginFragment)

        }, 5000)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finish_charge_, container, false)
    }

}