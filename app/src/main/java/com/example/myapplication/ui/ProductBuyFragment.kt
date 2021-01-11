package com.example.myapplication.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.BuyResponse
import com.example.myapplication.network.RetrofitClient
import kotlinx.android.synthetic.main.fragment_product_buy.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductBuyFragment : Fragment() {

    var id :String = ""
    var cell : String = ""

    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        cell = args?.getString("Cell").toString()
        id = args?.getString("Id").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_product_buy, container, false)
        RetrofitClient().buyProduct().buy(cell, id).enqueue(object : Callback<BuyResponse>{

            override fun onResponse(call: Call<BuyResponse>, response: Response<BuyResponse>) {
                if (response.body()?.buyProduct.toString() == "no") {
                    view.finish_ment.hint = "비어있는 공간입니다."
                } else {
                    view.finish_ment.hint = "구매 완료."
                }
                val mHandler = Handler()
                mHandler.postDelayed(Runnable {
                    findNavController().navigate(R.id.action_productBuyFragment_to_loginFragment)
                }, 4000)
            }

            override fun onFailure(call: Call<BuyResponse>, t: Throwable) {
                view.finish_ment.hint = "구매 실패."
            }

        })
        return view
    }
}