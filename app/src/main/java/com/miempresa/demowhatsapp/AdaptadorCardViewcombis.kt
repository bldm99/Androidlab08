package com.miempresa.demowhatsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCardViewcombis(val ListaElementos:ArrayList<Elementoswasap>): RecyclerView.Adapter<AdaptadorCardViewcombis.ViewHolder>() {

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val fTexto = itemView.findViewById<TextView>(R.id.elemento_texto)
        val fTextodis = itemView.findViewById<TextView>(R.id.elemento_distritoC)
        val fTextocali = itemView.findViewById<TextView>(R.id.elemento_calificacionC)
        val fImagen = itemView.findViewById<ImageView>(R.id.elemento_imagen);
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorCardViewcombis.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.elementoscardviewcombi, parent, false);
        return AdaptadorCardViewcombis.ViewHolder(v);
    }

    override fun onBindViewHolder(holder: AdaptadorCardViewcombis.ViewHolder, position: Int) {
        holder?.fTexto?.text=ListaElementos[position].texto
        holder?.fTextodis?.text=ListaElementos[position].texto2
        holder?.fTextocali?.text=ListaElementos[position].texto3
        holder?.fImagen?.setImageBitmap(ListaElementos[position].imagen)

        holder.itemView.setOnClickListener(){
            Toast.makeText(holder.itemView.context, "Pulsaste CardViev" + (position + 1) , Toast.LENGTH_SHORT).show()

            if (position == 0 ){
                val llamaractividad = Intent(holder.itemView.context, Escritura::class.java)
                llamaractividad.putExtra("dato","Ruta1")
                holder.itemView.context.startActivity(llamaractividad)
            }



        }





    }

    override fun getItemCount(): Int {
        return ListaElementos.size;
    }
}
