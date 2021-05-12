package com.example.lab03b;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab03b.AccesoDatos.ModelData
import com.example.lab03b.LogicaNegocio.Usuario
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        btnAgregarUsuario.setOnClickListener {
            var et_usuario = et_usuario.text.toString()
            var et_contrasenia = et_contrasenia.text.toString()
            if(validarCampos(et_usuario, et_contrasenia)){
                val usuario = Usuario(et_usuario, et_contrasenia)
                ModelData.agregarUsuario(usuario)
                var intent: Intent = Intent(this@RegistroActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }

    fun validarCampos(usuario:String, contrasenia:String):Boolean{
        return !usuario.isEmpty() and !contrasenia.isEmpty()
    }
}