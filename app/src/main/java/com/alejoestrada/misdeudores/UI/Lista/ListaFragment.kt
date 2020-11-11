package com.alejoestrada.misdeudores.UI.Lista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alejoestrada.misdeudores.MisDeudores
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.data.database.entities.Deudor
import com.alejoestrada.misdeudores.databinding.FragmentListaBinding


class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding
    var listDeudores: List<Deudor> = emptyList()  // lista de deudores vacia


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentListaBinding.bind(view)
        val deudorDAO = MisDeudores.database.DeudorDAO()   //cargar la lista; instancia del dao
        listDeudores = deudorDAO.getDeudores()
        //
        binding.deudoresRecyclerView.layoutManager =
            LinearLayoutManager(
                context,
                RecyclerView.VERTICAL,
                false
            )  // para la vista como estara la info
        binding.deudoresRecyclerView.setHasFixedSize(true) // para que el tamaño sea constante

        val deudoresRVAdapter =
            DeudoresRVAdapter(listDeudores as ArrayList<Deudor>)  //damos lista al adapter

        binding.deudoresRecyclerView.adapter =
            deudoresRVAdapter  // les damos al recyvler view la lista


        deudoresRVAdapter.notifyDataSetChanged() // se hace para notificar que cambiaron los datos porque se envio una lista vacia
    }


}