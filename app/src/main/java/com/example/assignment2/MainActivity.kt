package com.example.assignment2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.*
import android.view.Menu
import android.view.MenuItem
import android.view.MenuInflater as MenuInflater1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var orderButton : Button = findViewById(R.id.buttonOrder)
        //Creating Spinner Values
        var flag: String = "Not Selected"
        var spinnerOptions: Spinner = findViewById(R.id.spinnerOptions)
        var options = arrayOf("Not Selected","Cakes","Coffee")
        spinnerOptions.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,options)

        spinnerOptions.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        orderButton.setOnClickListener {
            when (flag) {
                "Coffee" -> {
                    var dialogVar = Coffee()
                    dialogVar.show(supportFragmentManager, "Coffee Order")
                }
                "Cakes" -> {
                    var dialogVar1 = CakeDialog()
                    dialogVar1.show(supportFragmentManager, "Coffee Order")
                }
            }
        }


    }

     fun receiveFeedback(feedback:String){
        val orderResult : TextView = findViewById(R.id.RtextView)
        orderResult.setVisibility(View.VISIBLE)
        orderResult.text = feedback
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.shop_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.cake -> {
                var dialogVar = CakeMenu()
                dialogVar.show(supportFragmentManager, "Coffee Menu")
            }
            R.id.coffee -> {
                var dialogVar = CoffeeMenu()
                dialogVar.show(supportFragmentManager, "Coffee Menu")
            }
        }
        return true;
    }

}