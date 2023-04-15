package com.example.colorguessgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter


class AnswerList : Fragment() {

    private lateinit var  ansArray: ArrayList<String>
    private lateinit var ColorRecycler: RecyclerView
    private lateinit var retryBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_answer_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ansArray = requireArguments().getStringArrayList("Ansfinal") as ArrayList<String>

        ColorRecycler = view.findViewById(R.id.ansRecycle)
        val Adapter = AnswerAdapter(ansArray)
        ColorRecycler.adapter = Adapter
        ColorRecycler.layoutManager = LinearLayoutManager(context)

        retryBtn = view.findViewById(R.id.retryBtn2)

        retryBtn.setOnClickListener{
            findNavController().navigate(R.id.action_answerList_to_secondScreen)
        }




    }
}