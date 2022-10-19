package com.miempresa.demowhatsapp

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_lista_card_viewcombis.*

class ListaCardViewcombis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_card_viewcombis)

        setSupportActionBar(findViewById(R.id.objtoolbar))
        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_preferences)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        lista.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this);

        var llenarLista = ArrayList<Elementoswasap>()

        val empresas = arrayOf(
            "Segrampo - C S.A ",
            "Cotum - B S.A",
            "Buses COTAP S.A. ",
            "Ocho de Octubre",
            "Empresa de Transporte 3 de Octubre S.A.",
            "Monteverde S.A",
            "Peruarbo Buss S.A.",
            "Litoral S.A."
        )

        val precios= arrayOf(
            "1.00/S ",
            "0.50/S",
            "0.50/S ",
            "2.00/S",
            "2.00/S",
            "1.00/S",
            "0.50/S",
            "1.00/S"
        )

        val calificacion= arrayOf(
            "5 estrellas ",
            "4 estrellas",
            "5 estrellas ",
            "4 estrellas",
            "5 estrellas",
            "3 estrellas",
            "5 estrellas",
            "2 estrellas"
        )


        val fotos1= arrayOf(
            R.drawable._8099dln,
            R.drawable.gato,
            R.drawable.imagen2,
            R.drawable.imagen4,
            R.drawable.imagen5,
            R.drawable.imagen6,
            R.drawable.imagen7,
            R.drawable.imagen8
        )


        for (i in 1 until 8) {
            llenarLista.add(
                Elementoswasap(empresas.get(i),precios.get(i),calificacion.get(i),
                BitmapFactory.decodeResource(resources, fotos1.get(i)))
            )
        }

        val adapter = AdaptadorCardViewcombis(llenarLista)
        lista.adapter = adapter
    }
}