package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.LoginResponse
import kotlinx.android.synthetic.main.fragment_wating.view.*

class WatingFragment : Fragment() {
    var getname: String = "000000"
    var getpoint: String = "000000"
    var getId: String = ""
    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        getname = args?.getString("Name").toString()
        getpoint = args?.getString("Point").toString()
        getId = args?.getString("Id").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wating, container, false)
        view.Product_buy.setOnClickListener {
            findNavController().navigate(R.id.action_watingFragment_to_buyLoctionFragment,BuyUserInfo(getpoint, getId))
        }
        view.Product_sell.setOnClickListener {
            findNavController().navigate(R.id.action_watingFragment_to_sellLocationFragment,SellUserInfo(getname,getId))
        }
        view.pointCharge.setOnClickListener {
            findNavController().navigate(R.id.action_watingFragment_to_chargePointFragment,BuyUserInfo(getpoint, getId))

        }
        view.username.hint = getname
        view.point.hint = getpoint
        return view;
    }

    fun BuyUserInfo(point: String, id: String): Bundle {
        val bundle = Bundle(2)
        bundle.putString("Point", point)
        bundle.putString("Id", id)
        return bundle
    }
    fun SellUserInfo(name: String, id: String): Bundle {
        val bundle = Bundle(2)
        bundle.putString("Name", name)
        bundle.putString("Id", id)
        return bundle
    }
}
