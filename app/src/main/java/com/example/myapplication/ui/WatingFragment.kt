package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.LoginResponse
import kotlinx.android.synthetic.main.fragment_wating.view.*

class WatingFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wating, container, false)
        view.Product_buy.setOnClickListener {
            findNavController().navigate(R.id.action_watingFragment_to_buyLoctionFragment)
        }
        view.Product_sell.setOnClickListener {
            findNavController().navigate(R.id.action_watingFragment_to_sellLocationFragment)
        }
        view.pointCharge.setOnClickListener {
            findNavController().navigate(R.id.action_watingFragment_to_chargePointFragment)

        }
        view.username.text = LoginResponse().username
        view.point.text = LoginResponse().point
        return view;
    }



}