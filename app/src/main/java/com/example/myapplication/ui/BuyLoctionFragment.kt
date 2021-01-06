package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_buy_loction.view.*


class BuyLoctionFragment : Fragment() {
    var getpoint: Int? = 0
    var id: String? = ""
    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        getpoint = args?.getString("Point")?.toInt()
        id = args?.getString("Id")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_buy_loction, container, false)
        view.buyFirst.setOnClickListener {
            findNavController().navigate(R.id.action_buyLoctionFragment_to_productBuyFragment)
            System.out.println("buyLocationId"+id); //확인
            System.out.println("buyLocationPoint"+getpoint); //확인
        }
        view.buySecond.setOnClickListener {
            findNavController().navigate(R.id.action_buyLoctionFragment_to_productBuyFragment)
        }
        view.buyThird.setOnClickListener {
            findNavController().navigate(R.id.action_buyLoctionFragment_to_productBuyFragment)
        }
        view.buyForth.setOnClickListener {
            findNavController().navigate(R.id.action_buyLoctionFragment_to_productBuyFragment)
        }
        view.point.hint = "포인트:"+getpoint.toString()
        return view
    }

}