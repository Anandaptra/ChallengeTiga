package com.example.challengetiga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengetiga.databinding.FragmentHurufBinding
import com.example.challengetiga.databinding.FragmentKataBinding

class KataFragment : Fragment() {
    val kataList = ArrayList<KataList>()
    lateinit var binding: FragmentKataBinding
    lateinit var rckata : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKataBinding.inflate(layoutInflater, container, false)
        val argumen= this.arguments
        val data = argumen?.get("Huruf")

        binding.txtStart.text = "Word That Start With $data"
        rckata = binding.rvKata
        rckata.setHasFixedSize(true)
        listKataShow()

        return binding.root
    }


    private fun getKata() : ArrayList<KataList> {
        val argument = this.arguments
        val data = argument?.get("Huruf")

        val kata = resources.getStringArray(R.array.kata)

        val listKata = ArrayList<KataList> ()
            for (i in kata.indices) {
                val kataPertama = kata[i].take(1)
                if(kataPertama == data) {
                    val kata = KataList(kata[i])
                    listKata.add(kata)
                }
            }
        return listKata
    }

    private fun listKataShow() {
        rckata.layoutManager = LinearLayoutManager(context)
        val listAdapter = ListAdapterKata(kataList)
        rckata.adapter = listAdapter
        kataList.clear()
        kataList.addAll(getKata())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgBack.setOnClickListener {
            findNavController().navigate(R.id.action_kataFragment_to_hurufFragment)
        }
    }

}