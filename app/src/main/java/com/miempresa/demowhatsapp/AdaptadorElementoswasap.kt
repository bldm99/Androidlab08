package com.miempresa.demowhatsapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class AdaptadorElementoswasap(val ListaElementos:ArrayList<Elementoswasap>):RecyclerView.Adapter<AdaptadorElementoswasap.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val fTexto = itemView.findViewById<TextView>(R.id.elemento_texto)
        val fImagen = itemView.findViewById<ImageView>(R.id.elemento_imagen);
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorElementoswasap.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.chatlista , parent , false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdaptadorElementoswasap.ViewHolder, position: Int) {
        holder?.fTexto?.text = ListaElementos[position].texto
        holder?.fImagen?.setImageBitmap(ListaElementos[position].imagen)
    }

    override fun getItemCount(): Int {
        return ListaElementos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        holder?.fTexto?.text = ListaElementos[position].texto
        holder?.fImagen?.setImageBitmap(ListaElementos[position].imagen)

        holder.itemView.setOnCreateContextMenuListener {contexMenu , _ , _ ->
            contexMenu.setHeaderTitle("Se eligio la opcion" + (position+1))
            true
        }
    }
}