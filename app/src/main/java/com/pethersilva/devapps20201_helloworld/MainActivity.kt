package com.pethersilva.devapps20201_helloworld

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pethersilva.devapps20201_helloworld.adapter.EstadoAdapter
import com.pethersilva.devapps20201_helloworld.model.Estado
import kotlinx.android.synthetic.main.activity_main_listview.*

class MainActivity : AppCompatActivity() {

	private val listEstados = mutableListOf(
		Estado("Paraíba", 0),
		Estado("Pernambuco", 1),
		Estado("Rio Grande do Norte", 2)
	)

	private val mEstadoAdapter by lazy { EstadoAdapter(this, listEstados) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main_listview)
		setupListview()
		setupInsertButton()
	}

	private fun setupInsertButton() {
		buttonInserir.setOnClickListener {
			val name = editTextPersonName.text.toString()
			if (isNameValid(name)) {
				listEstados.add(Estado(name, (0..2).random()))
				mEstadoAdapter.notifyDataSetChanged()
			}
		}
	}

	private fun isNameValid(name: String): Boolean = !name.isNullOrEmpty()

	private fun setupListview() {
		listView.setOnItemClickListener { parent, view
										  , position, id ->
			val (nome, bandeira) = listEstados[position]
			Toast.makeText(this, "click: $$nome $bandeira", Toast.LENGTH_SHORT).show()
		}
		listView.adapter = mEstadoAdapter
	}
}
