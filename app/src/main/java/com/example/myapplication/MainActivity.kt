package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bundle = bundleOf(FirstFragment.NAME_BUNDLE to "Primer", FirstFragment.ADDRESS_BUNDLE to "Second")

        supportFragmentManager.beginTransaction().add(R.id.fragContainer,FirstFragment()).commit()
    }
}