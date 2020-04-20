package com.demo.timecraft.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.timecraft.R
import com.demo.timecraft.ui.base.BaseActivity
import com.demo.timecraft.ui.home.fragment.HomeFragment

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replaceFragment(HomeFragment())
    }
}
