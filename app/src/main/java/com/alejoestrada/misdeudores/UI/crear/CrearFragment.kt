package com.alejoestrada.misdeudores.UI.crear

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alejoestrada.misdeudores.MisDeudores
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.data.database.dao.DeudorDAO
import com.alejoestrada.misdeudores.data.database.entities.Deudor
import com.alejoestrada.misdeudores.databinding.FragmentCrearBinding
import kotlinx.android.synthetic.main.fragment_crear.*
import java.sql.Types.NULL


class CrearFragment : Fragment() {

    private lateinit var binding: FragmentCrearBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crear, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding = FragmentCrearBinding.bind(view)


        binding.guardarButton.setOnClickListener {

            var nombre = nombre_edit_text?.text.toString()
            var telefono = telefono_edit_text?.text.toString()
            var valor = cantidad_edit_text?.text.toString()

            if (nombre != null && telefono != null && valor != null) {

                if (nombre != "" && telefono != "" && valor.toString() != "") {
                    val deudor = Deudor(NULL, nombre, telefono, valor.toLong())
                    val deudorDAO: DeudorDAO = MisDeudores.database.DeudorDAO()

                    deudorDAO.Insert(deudor)

                    binding.nombreEditText.text = null
                    binding.telefonoEditText.text = null
                    binding.cantidadEditText.text = null
                } else {
                    Toast.makeText(context, "falta algun campo por rellenar", Toast.LENGTH_SHORT)
                        .show()
                }


            } else {
                Toast.makeText(context, "falta algun campo por rellenar", Toast.LENGTH_SHORT).show()
            }


            //deudor.nombre?.let { it1 -> Log.d("nombre", it1) }
        }
    }

    companion object
}