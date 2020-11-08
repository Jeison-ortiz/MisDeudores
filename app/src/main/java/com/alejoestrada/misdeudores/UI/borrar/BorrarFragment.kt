package com.alejoestrada.misdeudores.UI.borrar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alejoestrada.misdeudores.MisDeudores
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.data.database.dao.DeudorDAO
import com.alejoestrada.misdeudores.databinding.FragmentBorrarBinding


class BorrarFragment : Fragment() {

    private lateinit var binding: FragmentBorrarBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_borrar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentBorrarBinding.bind(view)

        binding.borrarButton.setOnClickListener {
            val nombre = binding.nombreBorrarEditText.text.toString()
            val deudorDAO: DeudorDAO = MisDeudores.database.DeudorDAO()
            val deudor = deudorDAO.searchDeudor(nombre)

            if (deudor != null)
                deudorDAO.deleteDeudor(deudor)
            else {
                Toast.makeText(context, "No existe", Toast.LENGTH_SHORT).show()
            }
        }

    }


}