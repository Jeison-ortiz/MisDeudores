package com.alejoestrada.misdeudores.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alejoestrada.misdeudores.data.database.entities.Usuario


@Dao
interface UsuarioDAO {
    @Insert
    fun insertUsuario(usuario: Usuario)

    @Query("SELECT * FROM tabla_usuario WHERE correo like :correo")
    fun getCorreo(correo: String): Usuario

    @Query("SELECT * FROM tabla_usuario WHERE contrasena like :contrasena ")
    fun getContrasena(contrasena: String): Usuario


}