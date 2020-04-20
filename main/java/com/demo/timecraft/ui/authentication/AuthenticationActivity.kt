package com.demo.timecraft.ui.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.timecraft.R
import com.demo.timecraft.ui.authentication.fragment.LoginFragment
import com.demo.timecraft.ui.base.BaseActivity

class AuthenticationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        replaceFragment(LoginFragment())
    }
}
