package com.alejoestrada.misdeudores.UI.tabs

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.alejoestrada.misdeudores.R
import com.alejoestrada.misdeudores.UI.actualizar.ActualizarFragment
import com.alejoestrada.misdeudores.UI.borrar.BorrarFragment
import com.alejoestrada.misdeudores.UI.buscar.BuscarFragment
import com.alejoestrada.misdeudores.UI.crear.CrearFragment


private val TAB_TITLES = arrayOf(
    R.string.crear,
    R.string.buscar,
    R.string.Actualizar,
    R.string.Borrar
)


class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return CrearFragment()
            1 -> return BuscarFragment()
            2 -> return ActualizarFragment()
            else -> return BorrarFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}