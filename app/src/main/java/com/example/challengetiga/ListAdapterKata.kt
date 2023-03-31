package com.example.challengetiga

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.challengetiga.databinding.ItemHurufBinding

class ListAdapterKata (private val listKata : ArrayList<KataList>) : RecyclerView.Adapter<ListAdapterKata.ViewHolder>(){
    class ViewHolder (var binding: ItemHurufBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapterKata.ViewHolder {
        val binding = ItemHurufBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListAdapterKata.ViewHolder, position: Int) {
        val viewKata = listKata[position].kata
        holder.binding.tvHuruf.text = viewKata
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val transaction = p0?.context as AppCompatActivity

                val web = Intent(Intent.ACTION_VIEW)
                web.data = Uri.parse("https://www.google.com/search?q= $viewKata")
                transaction.startActivity(web)
            }

        })
    }

    override fun getItemCount(): Int {
        return listKata.size
    }
}