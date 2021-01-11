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
    var id: String = ""
    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        getpoint = args?.getString("Point")?.toInt()
        id = args?.getString("Id").toString()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_buy_loction, container, false)
        view.buyFirst.setOnClickListener {
            findNavController().navigate(R.id.action_buyLoctionFragment_to_productBuyFragment,BuyProduct("1",id))
        }
        view.buySecond.setOnClickListener {
            findNavController().navigate(R.id.action_buyLoctionFragment_to_productBuyFragment,BuyProduct("2",id))
        }
        view.buyThird.setOnClickListener {
            findNavController().navigate(R.id.action_buyLoctionFragment_to_productBuyFragment,BuyProduct("3",id))
        }
        view.buyForth.setOnClickListener {
            findNavController().navigate(R.id.action_buyLoctionFragment_to_productBuyFragment,BuyProduct("4",id))
        }
        view.point.hint = "포인트:"+getpoint.toString()
        return view
    }
    fun BuyProduct(cell: String, id: String): Bundle {
        val bundle = Bundle(2)
        bundle.putString("Cell",cell)
        bundle.putString("Id", id)
        return bundle
    }

}