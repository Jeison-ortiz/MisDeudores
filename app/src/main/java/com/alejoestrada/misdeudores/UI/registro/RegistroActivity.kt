package com.alejoestrada.misdeudores.UI.registro

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alejoestrada.misdeudores.MisDeudores
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.UI.login.LogInActivity2
import com.alejoestrada.misdeudores.data.database.dao.UsuarioDAO
import com.alejoestrada.misdeudores.data.database.entities.Usuario
import kotlinx.android.synthetic.main.activity_registro.*
import java.sql.Types.NULL

class RegistroActivity : AppCompatActivity() {


    companion object {
        private const val EMPTY= ""
        private const val SPACE= " "

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)


        registrar_button.setOnClickListener {

            val nombre = nombre_edit_view.text.toString()
            val correo = correo_edit_text.text.toString()
            val telefono = telefono_edit_text.text.toString()
            val contrasena = contrasena_edit_text.text.toString()
            val repcontrasena = repetircontra_edit_text.text.toString()

            if (contrasena == "" && repcontrasena == "" || contrasena != repcontrasena || contrasena.length < 6) {
                textView3.text =
                    "Contraseñas no coinciden, vuelva a intentar (deben tener al menos 6 digitos)// Passwords don't match, please check (the password needs at least 6 characters) "
            } else if (contrasena == repcontrasena && contrasena.length >= 6) {
                val intent = Intent(this, LogInActivity2::class.java)
                val usuario = Usuario(NULL, nombre, correo, telefono, contrasena)
                val usuarioDAO: UsuarioDAO = MisDeudores.database2.UsuarioDAO()
                usuarioDAO.insertUsuario(usuario)
                startActivity(intent)
                finish()
            }


        }
    }


    override fun onResume() {
        super.onResume()
        Log.d("Metodo","onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Metodo","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Metodo","onDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Metodo","onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Metodo", "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Metodo", "onRestart")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


}