package com.alejoestrada.misdeudores

import android.app.Application
import androidx.room.Room
import com.alejoestrada.misdeudores.data.server.DeudorDatabase
import com.alejoestrada.misdeudores.data.server.UsuarioDatabase

class MisDeudores : Application() {

    companion object {
        lateinit var database: DeudorDatabase
        lateinit var database2: UsuarioDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            DeudorDatabase::class.java,
            "deudor_DB"
        ).allowMainThreadQueries()
            .build()


        database2 = Room.databaseBuilder(
            this,
            UsuarioDatabase::class.java,
            "usuario_DB"
        ).allowMainThreadQueries()
            .build()
    }
}