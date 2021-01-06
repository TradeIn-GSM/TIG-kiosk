package com.example.myapplication.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R

class SellProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mHandler = Handler()
        mHandler.postDelayed(Runnable {
            findNavController().navigate(R.id.action_sellProductFragment_to_loginFragment)

        }, 7000)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sell_product, container, false)
    }


}