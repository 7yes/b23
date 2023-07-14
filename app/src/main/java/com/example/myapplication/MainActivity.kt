package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

// para instalar la funte primero descargalas por ej de google fonts, luego
//crear en package Res ckD(Android Resource Directory/ Font) , luego arrartar
// la font hasta el nuevo package font, darle refactor(el nombre solo debe tener
// minusculas y '_'), para asignar la font hay 2 formas
// en el XML con el agtributo fontFamily y en codigo tvFont.typeface = ResourcesCompat.getFont(this,R.font.dancing)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvFont:TextView = findViewById(R.id.tvFont1)
        tvFont.typeface = ResourcesCompat.getFont(this,R.font.dancing)
    }
}