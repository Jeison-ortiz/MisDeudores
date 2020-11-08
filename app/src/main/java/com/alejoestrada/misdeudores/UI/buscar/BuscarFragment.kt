package com.alejoestrada.misdeudores.UI.buscar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alejoestrada.misdeudores.MisDeudores
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.data.database.dao.DeudorDAO
import com.alejoestrada.misdeudores.databinding.FragmentBuscarBinding


class BuscarFragment : Fragment() {

    private lateinit var binding: FragmentBuscarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentBuscarBinding.bind(view)

        binding.button.setOnClickListener {
            val nombre = binding.nombreBuscarEditText.text.toString()

            val deudorDAO: DeudorDAO = MisDeudores.database.DeudorDAO()
            val deudor = deudorDAO.searchDeudor(nombre)

            if (deudor != null) {
                binding.telefonoTextView.text = deudor.telefono
                binding.cantidadTextView.text = deudor.valor.toString()
            } else {
                Toast.makeText(context, "No existe", Toast.LENGTH_SHORT).show()
            }

        }
    }

    companion object
}