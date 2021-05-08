package com.example.lab03b;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.example.lab03b.AccesoDatos.ModelData
import com.example.lab03b.LogicaNegocio.Usuario

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var intent: Intent? = null

        var btnIngresar = findViewById<Button>(R.id.btn_ingresar)
        btnIngresar.setOnClickListener{


            var usuarios = ModelData.obtenerUsuarios()
            var iterador:Iterator<Usuario> = usuarios.iterator()
            var usuario = findViewById<AppCompatEditText>(R.id.et_usuario).text.toString()
            var contrasenia = findViewById<AppCompatEditText>(R.id.et_contrasenia).text.toString()
            var encontrado = false
            for (item in usuarios){
                if (item.usuario == usuario && item.contrasenia == contrasenia){
                    Toast.makeText(this@LoginActivity,  "Ingreso correcto",Toast.LENGTH_SHORT).show()
                    encontrado = true
                    break
                }else if(item.usuario == usuario){
                    Toast.makeText(this@LoginActivity,  "Contraseña incorrecta",Toast.LENGTH_SHORT).show()
                    encontrado = true
                    break
                }
            }
            if(!encontrado){
                Toast.makeText(this@LoginActivity,  "Usuario no registrado",Toast.LENGTH_SHORT).show()
            }

        }

        var tvRegistrar = findViewById<TextView>(R.id.tv_registrar)
        tvRegistrar.setOnClickListener{
            intent = Intent(this@LoginActivity, RegistroActivity::class.java)
            startActivity(intent)
        }

        var tvCambContrasenia = findViewById<TextView>(R.id.tv_cambiar)
        tvCambContrasenia.setOnClickListener{
            intent = Intent(this@LoginActivity, CambiarContraseniaActivity::class.java)
            startActivity(intent)
        }

    }
}