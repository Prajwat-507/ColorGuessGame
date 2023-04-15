package com.example.colorguessgame

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController


class ResultPopUp : DialogFragment() {

    private var navController: NavController? = null
    private var anscount: Int = 0
    private lateinit var username: TextView
    private lateinit var retryBtn: Button
    private lateinit var rightOrderBtn: Button
    private lateinit var testarr: ArrayList<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_pop_up, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        testarr = ArrayList()
        username = view.findViewById(R.id.userName)
        retryBtn = view.findViewById(R.id.retryBtn)
        rightOrderBtn = view.findViewById(R.id.rightOrderBtn)

        anscount = requireArguments().getInt("Data") as Int
        val str = requireArguments().getString("Name") as String
        testarr = requireArguments().getStringArrayList("Ans") as ArrayList<String>


        if(anscount == 7){
            username.text = "$str You Win"
        }
        else{
            username.text = "$str You Lose"
        }

        retryBtn.setOnClickListener{
            findNavController().navigate(R.id.action_resultPopUp_to_secondScreen)
        }
        rightOrderBtn.setOnClickListener{
            findNavController().navigate(R.id.action_resultPopUp_to_answerList, Bundle().apply {
                putStringArrayList("Ansfinal",  testarr) })
            Log.d("tst", testarr.toString())
        }
    }

}