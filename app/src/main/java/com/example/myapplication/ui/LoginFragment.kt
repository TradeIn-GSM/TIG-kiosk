package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.data.LoginResponse
import com.example.myapplication.network.RetrofitClient
import com.example.myapplication.network.Service
import kotlinx.android.synthetic.main.fragment_login.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private var userid: String = ""

    private var password: String = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        view.login.setOnClickListener {
            Log.d("유저id",view.userid.text.toString())
            RetrofitClient().getUserAPI().Login(view.userid.text.toString(), view.userpassword.text.toString()).enqueue(object : Callback<LoginResponse>{

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>,
                ) {
                    findNavController().navigate(R.id.action_loginFragment_to_watingFragment)
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    println("실패실패실패실패실패실패실패실패")
                }

            })

        }
        return view
    }

}