package com.example.fragmentdisplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentManager = supportFragmentManager
        val fragmentTrans = fragmentManager.beginTransaction()

        val btnA : Button = findViewById(R.id.btnA)
        val btnB : Button = findViewById(R.id.btnB)
        val btnPut : Button = findViewById(R.id.btnPut)

        btnA.setOnClickListener(){
            val fragmentTrans = fragmentManager.beginTransaction()

            val fragment = AFragment()
            fragmentTrans.replace(R.id.fragmnetContainer, fragment)


            fragmentTrans.commit() //after transaction done, then commit
        }

        btnB.setOnClickListener(){
            val fragmentTrans = fragmentManager.beginTransaction()

            val fragment = BFragment()
            fragmentTrans.replace(R.id.fragmnetContainer, fragment)


            fragmentTrans.commit()
        }

        btnPut.setOnClickListener(){
            val fragment = supportFragmentManager.findFragmentById(R.id.fragmnetContainer) as AFragment

            fragment.requireView().findViewById<TextView>(R.id.tvResult).text = "John"
        }


    }
}