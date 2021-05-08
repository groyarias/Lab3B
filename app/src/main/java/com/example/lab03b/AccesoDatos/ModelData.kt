package com.example.lab03b.AccesoDatos

import com.example.lab03b.LogicaNegocio.Usuario

object ModelData {

    private val usuarios:MutableList<Usuario> = mutableListOf<Usuario>()

    init {
        inicializarUsuarios()
    }

    fun inicializarUsuarios(){
        usuarios.add(Usuario("@admin","admin"))
        usuarios.add(Usuario("@jorge","admin"))
        usuarios.add(Usuario("@roy","admin"))
    }

    fun obtenerUsuarios():MutableList<Usuario>{
        return usuarios
    }

}