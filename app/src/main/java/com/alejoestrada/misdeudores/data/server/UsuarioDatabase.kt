package com.alejoestrada.misdeudores.data.server

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alejoestrada.misdeudores.data.database.dao.UsuarioDAO
import com.alejoestrada.misdeudores.data.database.entities.Usuario

@Database(entities = [Usuario::class], version = 1)

abstract class UsuarioDatabase : RoomDatabase() {
    abstract fun UsuarioDAO(): UsuarioDAO
}


