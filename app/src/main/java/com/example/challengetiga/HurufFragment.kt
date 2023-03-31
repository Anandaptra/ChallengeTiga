package com.example.challengetiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengetiga.databinding.FragmentHurufBinding

class HurufFragment : Fragment() {
    val list = ArrayList<HurufList>()
    lateinit var binding: FragmentHurufBinding
    lateinit var rchuruf : RecyclerView
    //latevar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHurufBinding.inflate(layoutInflater, container, false)
        rchuruf = binding.rvHuruf
        rchuruf.setHasFixedSize(true)
        listHurufShow()
        binding.rvHuruf.setOnClickListener {

        }
        return binding.root
    }

    private fun getListHuruf() : ArrayList<HurufList> {
        val dataNama = resources.getStringArray(R.array.abjad)
        val listAbjad = ArrayList<HurufList>()
        for (i in dataNama.indices) {
            val abjad = HurufList(dataNama[i])
            listAbjad.add(abjad)
        }
        return listAbjad
    }

    private fun listHurufShow() {
        rchuruf.layoutManager =LinearLayoutManager(context)
        var listHurufAdapter = ListAdapterHuruf(list)
        rchuruf.adapter = listHurufAdapter
        list.clear()
        list.addAll(getListHuruf())
    }

}