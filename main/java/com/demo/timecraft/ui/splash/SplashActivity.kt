package com.demo.timecraft.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.demo.timecraft.R
import com.demo.timecraft.ui.authentication.AuthenticationActivity

class SplashActivity : AppCompatActivity() {

    lateinit var handler: Handler
    lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        handler = Handler()
        runnable = object:Runnable {
            override fun run() {
                startActivity(Intent(this@SplashActivity, AuthenticationActivity::class.java))
                finish()
            }

        }
        handler.postDelayed(runnable, 3000)
    }


    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
        startActivity(Intent(this@SplashActivity, AuthenticationActivity::class.java))
        finish()
    }
}
