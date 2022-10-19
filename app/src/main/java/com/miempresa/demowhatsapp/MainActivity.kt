package com.miempresa.demowhatsapp

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView


import kotlinx.android.synthetic.main.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Array.get

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)


        setSupportActionBar(findViewById(R.id.objtoolbar))
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        lista.addItemDecoration(DividerItemDecoration(this , DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this)

        var llenarLista = ArrayList<Elementoswasap>()


        val grupos = arrayOf(
            "Contruccion de Software ",
            "Futbol 4-C24",
            "4C24 ProMov. 2022",
            "4C24 DesarroolloAWeb. 2022",
            "C24 Bases de Datos",
            "C24 Ingieneria de Requerimientos",
            "C24 Programacion Orientada a Ob.",
            "C24 Desarrollo de A. Empresariales"
        )

        val fotos= arrayOf(
            R.drawable._8099dln,
            R.drawable.gato,
            R.drawable.imagen2,
            R.drawable.imagen4,
            R.drawable.imagen5,
            R.drawable.imagen6,
            R.drawable.imagen7,
            R.drawable.imagen8
        )

        var e = fotos.get(0)

        for(i in 0 until 8){
            llenarLista.add(Elementoswasap(grupos.get(i) ,"e", "r",
                BitmapFactory.decodeResource(resources , fotos.get(i))))
        }

        val adapter = AdaptadorElementoswasap(llenarLista)
        lista.adapter = adapter

        registerForContextMenu(lista)



    }


    //Creando menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuwasap,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var id : Int = item.itemId

        if(id == R.id.configuracion ){
            //Toast.makeText(this, "Elegiste menu Configuracion:" , Toast.LENGTH_SHORT).show()
            val llamaractividad = Intent(applicationContext,Configuracion::class.java)
            startActivity(llamaractividad)
            return true
        }

        if(id == R.id.acerca ){
            //Toast.makeText(this, "Elegiste menu Configuracion:" , Toast.LENGTH_SHORT).show()
            val llamaractividad = Intent(applicationContext,Acerca::class.java)
            startActivity(llamaractividad)
            return true
        }


        if(id == R.id.buscar ){
            //Toast.makeText(this, "Elegiste menu Buscar:" , Toast.LENGTH_SHORT).show()
            val llamaractividad = Intent(applicationContext,Buscar::class.java)
            startActivity(llamaractividad)
            return true
        }

        if (id == android.R.id.home) {
            layout_lateral.openDrawer(GravityCompat.START)
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    //--------------------------------------------Menu Contextual---------------------------------

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val x: MenuInflater = menuInflater
        x.inflate(R.menu.menucontextual , menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.eliminar->{
                //Toast.makeText(this, "Elegiste Eliminar" , Toast.LENGTH_SHORT).show()
                val llamaractividad = Intent(applicationContext,Acerca::class.java)
                startActivity(llamaractividad)
                return true

            }

            R.id.reportar ->{
                Toast.makeText(this, "Elegiste reportar" , Toast.LENGTH_SHORT).show()
            }

        }
        return true
    }
    //--------------------------------------------Menu Contextual---------------------------------

    //--------------acciones para la barra lateral---------------------------------
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.nav_chats-> {
                val llamaractividad = Intent(applicationContext, ListaCardViewcombis::class.java)
                startActivity(llamaractividad)
                return true
            }

        }
        return true
    }


}
