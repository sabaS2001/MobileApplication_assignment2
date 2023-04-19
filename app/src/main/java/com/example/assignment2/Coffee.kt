package com.example.assignment2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class Coffee : DialogFragment(R.layout.coffee_frag){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        val cancel : Button = view.findViewById(R.id.cancelBT)
        val submit: Button = view.findViewById(R.id.coffeeBT)
        val radioGroup = view.findViewById<RadioGroup>(R.id.CoffeeRadioGroup)
        cancel.setOnClickListener{
            dismiss()
        }
        submit.setOnClickListener{
            val selectedOption:Int = radioGroup.checkedRadioButtonId
            val radioButton = view.findViewById<RadioButton>(selectedOption)
            Toast.makeText(context,radioButton.text, Toast.LENGTH_SHORT).show()
            val m1:MainActivity = getActivity() as MainActivity
            m1.receiveFeedback(radioButton.text.toString())
            dismiss()
        }
    }

}