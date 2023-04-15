package com.example.colorguessgame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController


class SecondScreen : Fragment() {
    lateinit var Name: EditText
    lateinit var startBtn: Button
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        Name = view.findViewById(R.id.nameText)
         startBtn = view.findViewById(R.id.startBtn)
//
//        val bundle = Bundle()
//        bundle.putString("Data", Name.toString())
//        val fragment = ThirdScreen()
//        fragment.arguments = bundle
//        childFragmentManager.beginTransaction().replace(R.id.nav_graph, fragment).commit()


            startBtn.setOnClickListener {
                if (Name.text.toString().isEmpty()) {
                    Toast.makeText(context, "Please Enter Your Name", Toast.LENGTH_LONG).show()
                }

                else{
                    findNavController().navigate(R.id.action_secondScreen_to_thirdScreen, Bundle().apply { putString("Name", Name.text.toString()) } )
                }
            }
    }


    }
