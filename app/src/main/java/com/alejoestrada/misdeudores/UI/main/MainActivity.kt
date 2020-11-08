package com.alejoestrada.misdeudores.UI.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.UI.buscar.BuscarFragment
import com.alejoestrada.misdeudores.UI.crear.CrearFragment

class MainActivity : AppCompatActivity() {
    private val manager = supportFragmentManager
    private var transaction = manager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val crearFragment = CrearFragment()
        transaction.add(R.id.contenedor, crearFragment).commit()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        transaction = manager.beginTransaction()

        when (item.itemId) {
            R.id.nav_crear -> {
                val crearFragment = CrearFragment()
                transaction.replace(R.id.contenedor, crearFragment).commit()

            }
            R.id.nav_buscar -> {
                val buscarFragment = BuscarFragment()
                transaction.replace(R.id.contenedor, buscarFragment).commit()

            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}