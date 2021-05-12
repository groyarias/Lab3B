package com.example.lab03b.AccesoDatos

import com.example.lab03b.LogicaNegocio.JobApplication
import com.example.lab03b.LogicaNegocio.Usuario
import java.util.*
import kotlin.collections.ArrayList

object ModelData {
    private val usuarios:ArrayList<Usuario> = arrayListOf<Usuario>()
    private val jobApplications:ArrayList<JobApplication> = arrayListOf<JobApplication>()

    init {
        inicializarUsuarios()
        inicializarJobApplications()
    }

    fun inicializarUsuarios(){
        usuarios.add(Usuario("@admin","admin"))
        usuarios.add(Usuario("@jorge","admin"))
        usuarios.add(Usuario("@roy","admin"))
    }

    fun obtenerUsuarios():ArrayList<Usuario>{
        return usuarios
    }

    fun agregarUsuario(usuario:Usuario){
        usuarios.add(usuario)
    }

    fun modificarUsuario(usuarioModificado: Usuario):Boolean{
        for(i in 0..usuarios.size){
            if(usuarios[i].usuario == usuarioModificado.usuario){
                usuarios[i] = usuarioModificado
                return true
            }
        }
        return false
    }

    fun inicializarJobApplications(){
        jobApplications!!.add(JobApplication("Carlos","Sanchez","Central","Central","Alajuela","Alajuela",20101,"Costa Rica","csanchez@gmail.com","+506",888888,"Programador",
            Date()
        ))
        jobApplications!!.add(JobApplication("Sofia","Brenes","Central","Central","Alajuela","Alajuela",20101,"Costa Rica","sbrenes@gmail.com","+506",888888,"Programador",
            Date()
        ))

    }

    fun obtenerJobApplications():ArrayList<JobApplication>{
        return jobApplications
    }

}