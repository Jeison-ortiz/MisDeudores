package com.alejoestrada.misdeudores.UI.login

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alejoestrada.misdeudores.MisDeudores
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.UI.Boton.BotonActivity
import com.alejoestrada.misdeudores.UI.registro.RegistroActivity
import com.alejoestrada.misdeudores.data.database.dao.UsuarioDAO
import kotlinx.android.synthetic.main.activity_log_in2.*
import kotlinx.android.synthetic.main.activity_registro.*

class LogInActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in2)



        registro_button.setOnClickListener {
            val Intent = Intent(this, RegistroActivity::class.java)
            startActivity(Intent)

        }

        login_button.setOnClickListener {

            val correoUser = correo_edit_text.text.toString()
            val contrasenaUser = password_edit_text.text.toString()

            val usuarioDAO: UsuarioDAO = MisDeudores.database2.UsuarioDAO()
            val usuario = usuarioDAO.getCorreo(correoUser)

            if (usuario != null) {
                if (contrasenaUser == usuario.contrasena && correoUser == usuario.correo) {
                    val intent = Intent(this, BotonActivity::class.java)

                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            } else {
                Toast.makeText(this, "el usuario no existe", Toast.LENGTH_SHORT).show()
            }

            // val password = usuarioDAO.getContrasena(contrasenaUser)

        }
    }
}