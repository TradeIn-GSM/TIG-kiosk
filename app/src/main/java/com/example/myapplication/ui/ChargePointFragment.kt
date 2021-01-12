package com.example.myapplication.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.network.RetrofitClient
import kotlinx.android.synthetic.main.fragment_charge_point.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ChargePointFragment : Fragment() {
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
        var view = inflater.inflate(R.layout.fragment_charge_point, container, false)
        view.chargeCheckButton.setOnClickListener {

        }
        view.chargePointButton.setOnClickListener {
            RetrofitClient().moneyAPI().insertMoney(view.chargePointMoney.text.toString())//돈확인한것으로 수정해야됨
                .enqueue(object : Callback<Void>{
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        RetrofitClient().moneyAPI().charge(view.chargePointMoney.text.toString(),id)
                            .enqueue(object : Callback<Void>{
                            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                                findNavController().navigate(R.id.action_chargePointFragment_to_finish_charge_Fragment)
                            }

                            override fun onFailure(call: Call<Void>, t: Throwable) {

                            }

                        })
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {

                    }

                })
        }
        return view
    }
}