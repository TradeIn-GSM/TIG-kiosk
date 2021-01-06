package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_buy_loction.view.*
import kotlinx.android.synthetic.main.fragment_sell_location.view.*


class SellLocationFragment : Fragment() {
    var username: String = ""
    var userid: String = ""
    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        username = args?.getString("Name").toString()
        userid = args?.getString("Id").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sell_location, container, false)

        view.sellFirst.setOnClickListener {
            findNavController().navigate(R.id.action_sellLocationFragment_to_sellPriceFragment,SellUserInfo("1",this.username,this.userid))
        }
        view.sellSecond.setOnClickListener {
            findNavController().navigate(R.id.action_sellLocationFragment_to_sellPriceFragment,SellUserInfo("2",this.username,this.userid))
        }
        view.sellThird.setOnClickListener {
            findNavController().navigate(R.id.action_sellLocationFragment_to_sellPriceFragment,SellUserInfo("3",this.username,this.userid))
        }
        view.sellForth.setOnClickListener {
            findNavController().navigate(R.id.action_sellLocationFragment_to_sellPriceFragment,SellUserInfo("4",this.username,this.userid))
        }
        return view
    }
    fun SellUserInfo(cell: String, name: String, id: String): Bundle {
        val bundle = Bundle(3)
        bundle.putString("Cell", cell)
        bundle.putString("Name", name)
        bundle.putString("Id", id)
        return bundle
    }


}