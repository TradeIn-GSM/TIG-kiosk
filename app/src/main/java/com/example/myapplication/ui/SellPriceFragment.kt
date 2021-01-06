package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.network.RetrofitClient
import kotlinx.android.synthetic.main.fragment_sell_price.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SellPriceFragment : Fragment() {
    var cell: String = ""
    var username: String = ""
    var userid: String = ""

    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        cell = args?.getString("Cell").toString()
        username = args?.getString("Name").toString()
        userid = args?.getString("Id").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        var view = inflater.inflate(R.layout.fragment_sell_price, container, false)
        view.sellButton.setOnClickListener {
            RetrofitClient().sellProduct()
                .sell(cell, username, userid, view.sellPrice.text.toString())
                .enqueue(object : Callback<Void>{
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        findNavController().navigate(R.id.action_sellPriceFragment_to_sellProductFragment)
                        println(cell)
                        println(username)
                        println(userid)
                        println(view.sellPrice.text.toString())
                        println("판매 등록 성공")
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        println("판매 등록 실패")
                    }

                })
        }
        return view
    }


}