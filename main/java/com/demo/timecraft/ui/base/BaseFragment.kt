package com.demo.timecraft.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    lateinit var baseActivity: BaseActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseActivity = activity as BaseActivity
    }

    fun replaceFragment(fragment: Fragment, isBackStack: Boolean = true) {
        baseActivity.replaceFragment(fragment, isBackStack)
    }

    fun addFragment(fragment: Fragment, isBackStack: Boolean = true) {
        baseActivity.addFragment(fragment, isBackStack)
    }
}