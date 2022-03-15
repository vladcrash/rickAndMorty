package com.razgonyaev.rickandmortyapp.entrypoint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.razgonyaev.rickandmortyapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            Navigator.navigateToCharacterList(supportFragmentManager)
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}