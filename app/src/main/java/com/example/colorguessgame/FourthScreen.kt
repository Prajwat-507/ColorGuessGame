package com.example.colorguessgame

import android.location.GnssAntennaInfo.Listener
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.IntegerRes
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController


class FourthScreen : Fragment() {

    private lateinit var submmitBtn: Button
    private lateinit var clearAllBtn: Button

    private var navController: NavController? = null

    private lateinit var RedCard: CardView
    lateinit var numText1: TextView
    var boolRed: Boolean = false
    var num1 :Int = 0

    private lateinit var BlueCard: CardView
    lateinit var numText2: TextView
    var boolBlue: Boolean = false
    var num2 :Int = 0

    private lateinit var YellowCard: CardView
     lateinit var numText3: TextView
    var boolYellow: Boolean = false
    var num3 :Int = 0

    private lateinit var GreenCard: CardView
     lateinit var numText4: TextView
    var boolGreen: Boolean = false
    var num4 :Int = 0

    private lateinit var OrangeCard: CardView
    lateinit var numText5: TextView
    var boolOrange: Boolean = false
    var num5 :Int = 0

    private lateinit var PurpleCard: CardView
    private lateinit var numText6: TextView
    var boolPurple: Boolean = false
    var num6 :Int = 0

    private lateinit var  PinkCard: CardView
    private lateinit var numText7: TextView
    var boolPink: Boolean = false
    var num7 :Int = 0

    var count: Int =1

    private var ansMap = mutableMapOf<String, Int>()
    private lateinit var arr1: ArrayList<String>

    private  val nameUser: TextView?=null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        submmitBtn = view.findViewById(R.id.subbutton)
        clearAllBtn = view.findViewById(R.id.ClearAllBtn)

        RedCard = view.findViewById(R.id.cardView1)
        numText1 = view.findViewById(R.id.Textnum1)
     //   var r = numText1.text.toString().toInt()

        RedCard.setOnClickListener{

            if (boolRed == false) {
                numText1.text = count.toString()
                count++
                boolRed = true
            }
            else {
                count--
                numText1.text = "0"
                boolRed = false
            }
            num1 = numText1.text.toString().toInt()
        }

        BlueCard = view.findViewById(R.id.cardView2)
        numText2 = view.findViewById(R.id.Textnum2)

        BlueCard.setOnClickListener{

            if (boolBlue == false) {
                numText2.text = count.toString()
                count++
                boolBlue = true
            }
            else {
                count--
                numText2.text = "0"
                boolBlue = false
            }
            num2 = numText2.text.toString().toInt()
        }

        YellowCard = view.findViewById(R.id.cardView3)
        numText3 = view.findViewById(R.id.Textnum3)

        YellowCard.setOnClickListener{

            if (boolYellow == false) {
                numText3.text = count.toString()
                count++
                boolYellow = true
            }
            else {
                count--
                numText3.text = "0"
                boolYellow = false
            }
            num3 = numText3.text.toString().toInt()
        }

        GreenCard = view.findViewById(R.id.cardView4)
        numText4 = view.findViewById(R.id.Textnum4)

        GreenCard.setOnClickListener{

            if (boolGreen == false) {
                numText4.text = count.toString()
                count++
                boolGreen = true
            }
            else {
                count--
                numText4.text = "0"
                boolGreen = false
            }
            num4 = numText4.text.toString().toInt()
        }

        OrangeCard = view.findViewById(R.id.cardView5)
        numText5 = view.findViewById(R.id.Textnum5)

        OrangeCard.setOnClickListener{

            if (boolOrange == false) {
                numText5.text = count.toString()
                count++
                boolOrange = true
            }
            else {
                count--
                numText5.text = "0"
                boolOrange = false
            }
            num5 = numText5.text.toString().toInt()
        }

        PurpleCard = view.findViewById(R.id.cardView6)
        numText6 = view.findViewById(R.id.Textnum6)

        PurpleCard.setOnClickListener{

            if (boolPurple == false) {
                numText6.text = count.toString()
                count++
                boolPurple = true
            }
            else {
                count--
                numText6.text = "0"
                boolPurple = false
            }
            num6 = numText6.text.toString().toInt()
        }

        PinkCard = view.findViewById(R.id.cardView7)
        numText7 = view.findViewById(R.id.Textnum7)

        PinkCard.setOnClickListener{

            if (boolPink == false) {
                numText7.text = count.toString()
                count++
                boolPink = true
            }
            else {
                count--
                numText7.text = "0"
                boolPink = false
            }
            num7 = numText7.text.toString().toInt()
        }

        clearAllBtn.setOnClickListener{
            count =1
            num1=0 ; num2=0 ; num3=0 ; num4=0 ; num5=0 ; num6=0 ; num7=0

            numText1.text = "0" ; numText2.text = "0" ; numText3.text = "0" ; numText4.text = "0" ; numText5.text = "0"
            ; numText6.text = "0" ; numText7.text = "0"

            boolRed = false ; boolBlue = false ; boolYellow = false ; boolPurple = false ; boolPink = false ; boolGreen = false
            ; boolOrange = false
        }

        var countsame=0

        submmitBtn.setOnClickListener {
            arr1 = requireArguments().getStringArrayList("Data") as ArrayList<String>
            ansMap = mutableMapOf("Red" to num1, "Blue" to num2,
                "Yellow" to num3, "Green" to num4,
                "Orange" to num5, "Purple" to num6,
                "Pink" to num7)

            for (i in 0..6) {
                if (ansMap.getValue(arr1.get(i)) == i + 1) {
                    countsame++
                }
            }

            //nameUser?.text  = requireArguments().getString("Name") as String
            findNavController().navigate(R.id.action_fourthScreen_to_resultPopUp, Bundle().apply { putInt("Data", countsame,)
                putString("Name",requireArguments().getString("Name"))
                putStringArrayList("Ans", arr1)})

            Log.d("fs", ansMap.toString())
            Log.d("fa", arr1.toString())
            Log.d("fc", nameUser.toString())

        }





    }
}