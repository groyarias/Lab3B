package com.example.lab03b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lab03b.AccesoDatos.ModelData
import com.example.lab03b.LogicaNegocio.Usuario
import kotlinx.android.synthetic.main.activity_cambiar_contrasenia.*

class CambiarContraseniaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambiar_contrasenia)

        btn_editUser.setOnClickListener {
            var usuario = et_usuario.text.toString()
            var actual = et_contrasenia_actual.text.toString()
            var nueva = et_nueva_contrasenia.text.toString()
            var confirmacion = et_confirmacion_contrasenia.text.toString()

            if(validarCampos(usuario, actual, nueva, confirmacion)){
                if(nueva.equals(confirmacion)){
                    val usuario:Usuario = Usuario(usuario, nueva)
                    if(ModelData.modificarUsuario(usuario)){
                        var intent: Intent = Intent(this@CambiarContraseniaActivity, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this, "Problemas al modificar el usuario.", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this, "Contraseña mueva no coincide con confirmación.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun validarCampos(usuario: String, actual: String, nueva: String, confirmacion: String): Boolean {
        return (!usuario.isEmpty() && !actual.isEmpty() && !nueva.isEmpty() && !confirmacion.isEmpty())
    }

}