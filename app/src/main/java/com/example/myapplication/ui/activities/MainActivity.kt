package com.example.myapplication.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.fragments.HomeFragment
import com.example.myapplication.ui.fragments.ProfileFragment
import com.example.myapplication.ui.fragments.SupportFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.frameContainer,HomeFragment()).commit()

        binding.bottomNavMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.mHome -> supportFragmentManager.beginTransaction().replace(R.id.frameContainer,HomeFragment()).commit()
                R.id.mProfile -> supportFragmentManager.beginTransaction().replace(R.id.frameContainer,ProfileFragment()).commit()
                R.id.mSupport -> supportFragmentManager.beginTransaction().replace(R.id.frameContainer,SupportFragment()).commit()
                R.id.mExit -> finish()
            }
            true
        }
    }
}