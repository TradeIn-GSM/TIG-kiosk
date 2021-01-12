package com.example.myapplication.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.network.RetrofitClient
import kotlinx.android.synthetic.main.fragment_sign_up.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpFragment : Fragment() {
    lateinit var userId : String
    lateinit var userPass : String
    lateinit var userName : String
    lateinit var userPassCheck : String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        view.signupTologinButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }
        view.signupButton.setOnClickListener {
            userId = view.editTextEmail.text.toString()
            userPass = view.editTextPassword.text.toString()
            userName = view.editTextPersonName.text.toString()
            userPassCheck = view.textViewCheckPass.text.toString()
            if (userId==""||userName==""||userPass==""||userPassCheck==""){
                if (userId==""){
                    println(userId)
                    view.textViewId.setTextColor(Color.RED)
                }
                if (userName==""){
                    println(userName)
                    view.textViewPersonName.setTextColor(Color.RED)
                }
                if (userPass==""){
                    println(userPass)
                    view.TextViewPassword.setTextColor(Color.RED)
                }
                if (userPass!=userPassCheck){
                    view.TextViewPassword.setTextColor(Color.RED)
                    view.textViewCheckPass.setTextColor(Color.RED)
                }
            } else{
                RetrofitClient().getUserAPI().join(userId,userName,userPass).enqueue(object :
                    Callback<Void>{
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.code()==200){
                            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {

                    }

                })
            }

        }

        return view
    }


}