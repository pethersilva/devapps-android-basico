package com.pethersilva.devapps20201_helloworld

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.GridLayout
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.pethersilva.devapps20201_helloworld.adapter.EstadoAdapter
import com.pethersilva.devapps20201_helloworld.model.Estado
import kotlinx.android.synthetic.main.activity_main_listview.*

class MainActivity : AppCompatActivity() {
	private val listEstados = mutableListOf(
		Estado("Paraíba", 0),
		Estado("Pernambuco", 1),
		Estado("Rio Grande do Norte", 2)
	)
	private val mEstadoAdapter = EstadoAdapter(this,listEstados, this::onEstadoClickListener)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main_listview)
		setupRecyclerview()
		setupInsertButton()
	}

	private fun setupRecyclerview() {
		recyclerView.adapter = mEstadoAdapter
		val layoutManager = GridLayoutManager(this, 2)
		layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
			override fun getSpanSize(position: Int): Int {
				return if (position == 0) 2 else 1
			}
		}
		recyclerView.layoutManager = layoutManager
	}

	private fun onEstadoClickListener(estado: Estado) {
		Toast.makeText(this, "Estado: ${estado.nome} Bandeira: ${estado.bandeira}",
			Toast.LENGTH_SHORT).show()
	}

	private fun setupInsertButton() {
		buttonInserir.setOnClickListener {
			val name = editTextPersonName.text.toString()
			if (isNameValid(name)) {
				listEstados.add(Estado(name, (0..2).random()))
				mEstadoAdapter.notifyItemInserted(listEstados.lastIndex)
				editTextPersonName.text.clear()
				editTextPersonName.clearFocus()
			}
		}
	}
	private fun isNameValid(name: String): Boolean = !name.isNullOrEmpty()
}
