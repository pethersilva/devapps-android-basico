package com.pethersilva.devapps20201_helloworld

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pethersilva.devapps20201_helloworld.adapter.EstadoAdapter
import com.pethersilva.devapps20201_helloworld.model.Estado
import kotlinx.android.synthetic.main.activity_main_listview.*

class MainActivity : AppCompatActivity() {

	private val listEstados = listOf(
		Estado("Paraíba", 0),
		Estado("Pernambuco", 1),
		Estado("Rio Grande do Norte", 2)
	)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main_listview)
		val adapter = EstadoAdapter(this, listEstados)

		listView.setOnItemClickListener { parent, view
										  , position, id ->
			val(nome, bandeira) = listEstados[position]
			Toast.makeText(this, "click: $$nome $bandeira", Toast.LENGTH_SHORT).show()
		}
		listView.adapter = adapter
	}
}
