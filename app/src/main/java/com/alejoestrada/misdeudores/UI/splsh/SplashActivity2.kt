package com.alejoestrada.misdeudores.UI.splsh

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.UI.login.LogInActivity2
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)


        val timer = Timer()

        //hay que colocar tiempo en el splash
        timer.schedule(
            timerTask {
                goToLoginActivity()

            }, 1000

        )
    }

      fun goToLoginActivity() {
        //intent disparo de actvidades
        val intent = Intent(this, LogInActivity2::class.java)
        //start activity
        startActivity(intent)
         finish()
      }


}