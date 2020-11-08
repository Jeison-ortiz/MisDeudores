package com.alejoestrada.misdeudores.UI.Lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.data.database.entities.Deudor
import com.alejoestrada.misdeudores.databinding.DeudoresItemBinding

// desde el fragmento le mandamos la lista con los deudores,  el tipo es Arraylist de tipo deudor

// hereda de RecyclerView.Adapter y se le dice cual es el adapter
class DeudoresRVAdapter(var deudoresList: ArrayList<Deudor>) :
    RecyclerView.Adapter<DeudoresRVAdapter.DeudoresViewHolder>() {

    // paren es el papa que lo contiene, retorna un DeudoresViewHolder lo que esta despues de :
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DeudoresViewHolder { // creamos el item view
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.deudores_item, parent, false)
        return DeudoresViewHolder(itemView)
    }


    //  para mostrar la cantidad de datos que tenga
    override fun onBindViewHolder(holder: DeudoresViewHolder, position: Int) {
        val deudor = deudoresList[position]
        holder.bindDeudor(deudor)
    }

    override fun getItemCount(): Int {
        return deudoresList.size
    }


    // cuando la clase esta en rojo se deben poner las funciones de sobrecarga que el nos da por defecto
    // esta ereda de RecyclerView.ViewHolder
    class DeudoresViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) { // el itemVIew los manda la clase externa
        private val binding = DeudoresItemBinding.bind(itemView)

        fun bindDeudor(deudor: Deudor) {  // establece la información a mostrar
            binding.nombreTextView.text = deudor.nombre
            binding.valorTextView.text = deudor.valor.toString()
        }
    }


}