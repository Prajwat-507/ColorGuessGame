package com.example.colorguessgame

import android.graphics.Color
import android.graphics.DiscretePathEffect
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.MainThread
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.EnumSet.range
import java.util.Timer
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class ThirdScreen : Fragment()  {

    private lateinit var user: TextView
    private lateinit var colorView: ImageView
    private var navController: NavController? = null
    private lateinit var arr: ArrayList<String>
    private var colorMap = mutableMapOf<String, String>()
    private lateinit var colorNameView: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        user = view.findViewById(R.id.userName)
        navController = Navigation.findNavController(view)
        colorView = view.findViewById(R.id.colorView)
        colorNameView = view.findViewById(R.id.colorText)

        user.text = requireArguments().getString("Name") as String

//        val args = this.arguments
//        user.text = args?.get("Data").toString()

        var colorName : String
        var colorValue : Int

        arr = arrayListOf("Red", "Blue", "Yellow", "Green", "Orange", "Purple", "Pink")

        colorMap = mutableMapOf("Red" to "#FFFF0000", "Blue" to "#FF07AEFA","Yellow" to "#FFFFEB3B", "Green" to "#FF08A50F",
            "Orange" to "#FFFF5722", "Purple" to "#FF7736E9", "Pink" to "#FFF333DF")


        //Log.d("shu", colorMap.toString())

        GlobalScope.launch(Dispatchers.Main) {
            for(i in 0..6){
                val colorvalue = arr.get(i)
                colorNameView.text = colorvalue.toString()
                colorView.setBackgroundColor(Color.parseColor(colorMap.get(colorvalue)))
                delay(1000)

                if(i == 6) {
                    // navController!!.navigate(R.id.action_thirdScreen_to_fourthScreen)
                    findNavController().navigate(
                        R.id.action_thirdScreen_to_fourthScreen,
                        Bundle().apply { putStringArrayList("Data", arr)
                        putString("Name", user.text.toString())})
                }
            }

        }

        arr.shuffle()
        Log.d("shu", colorMap.toString())

    }
}
