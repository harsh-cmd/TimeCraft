package com.demo.timecraft.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.demo.timecraft.R

abstract class BaseActivity : AppCompatActivity() {

    lateinit var supportManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportManager = supportFragmentManager
    }

    fun replaceFragment(fragment: Fragment, isBackStack: Boolean = false) {
        val transaction = supportManager.beginTransaction()
        transaction.replace(R.id.placeHolder, fragment)
        if (isBackStack)
            transaction.addToBackStack(fragment::class.java.name)
        transaction.commit()
    }

    fun addFragment(fragment: Fragment, isBackStack: Boolean = false) {
        val transaction = supportManager.beginTransaction()
        transaction.add(R.id.placeHolder, fragment)
        if (isBackStack)
            transaction.addToBackStack(fragment::class.java.name)
        transaction.commit()
    }
}