package com.example.challengetiga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.challengetiga.databinding.ItemHurufBinding

class ListAdapterHuruf (private  var hurufList : ArrayList<HurufList>) :
    RecyclerView.Adapter<ListAdapterHuruf.ViewHolder>(){
    class ViewHolder (var binding : ItemHurufBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =ItemHurufBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewHuruf = hurufList[position].huruf
        holder.binding.tvHuruf.text = viewHuruf
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(pO: View?) {
                val transaction = pO?.context as AppCompatActivity

                val bundle = Bundle()
                bundle.putString("Huruf", viewHuruf)

                val kataFragment = KataFragment()
                kataFragment.arguments = bundle
                transaction.supportFragmentManager.beginTransaction()
                    .replace(R.id.fr_container, kataFragment)
                    .addToBackStack(null)
                    .commit()
            }
        })
    }

    override fun getItemCount(): Int {
        return hurufList.size
    }
}
