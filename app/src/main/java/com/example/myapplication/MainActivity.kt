package com.example.myapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCamera.setOnClickListener {
            checkPermissions()
        }
    }

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission( // aca importante al poner Manifest debe escojer el de android no el de java
                this,
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // no aceptado o no mostrado nunca
            requestCamaraPermission()
        } else {
            // abrir camara
            openCamara()
        }
    }

    private fun openCamara() {
        Toast.makeText(this, "Abriendo Camara", Toast.LENGTH_SHORT).show()
    }

    private fun requestCamaraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                android.Manifest.permission.CAMERA
            )
        ) {
            // el usuario ha rechado previamente el permiso
            Toast.makeText(this, "debes abrir sr usuario y otorgar permisos", Toast.LENGTH_SHORT)
                .show()

        } else {
            //mostrar permisos por primera vez
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA),
                777
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 777) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                openCamara()
            else // permisos rechazados 1ra
                Toast.makeText(this, "permisos rechazod por 1ra vez", Toast.LENGTH_SHORT).show()
        }
    }

}